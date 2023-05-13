package com.demo.mypay.businessService;

import com.demo.mypay.api.dto.OTPRequestDto;
import com.demo.mypay.businessService.converter.OTPConverter;
import com.demo.mypay.domain.OneTimePassword;
import com.demo.mypay.enums.OTPStatus;
import com.demo.mypay.repository.OTPRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class OTPBusinessService {

    private final OTPRepository otpRepository;
    private final OTPConverter otpConverter;

    public void createAndSend(OTPRequestDto otpRequestDto) {
        updateUnusedCodes(otpRequestDto);
        create(otpRequestDto);
        sendOTP();
    }

    private void updateUnusedCodes(OTPRequestDto otpRequestDto) {
        List<OneTimePassword> oneTimePasswords = otpRepository.findByOtpStatusAndOtpIdentifier(OTPStatus.CREATED, otpRequestDto.getOtpIdentifier());
        if (oneTimePasswords != null) {
            for (OneTimePassword otp : oneTimePasswords) {
                otp.setOtpStatus(OTPStatus.UNUSED);
                otpRepository.save(otp);
            }
        }
    }
    private void create(OTPRequestDto otpRequestDto) {
        OneTimePassword oneTimePassword = otpConverter.convert(otpRequestDto);
        oneTimePassword.setOtpStatus(OTPStatus.CREATED);
        otpRepository.save(oneTimePassword);
    }
    private void sendOTP() {
        // TODO: 4/28/2023 send SMS
    }

    public void validate(OTPRequestDto otpRequestDto) {
        OneTimePassword oneTimePassword = otpRepository.findByOtpIdentifierAndCodeAndOtpStatusAndOtpType(otpRequestDto.getOtpIdentifier(),otpRequestDto.getCode(), OTPStatus.CREATED,otpRequestDto.getOtpType()).orElseThrow(() -> new RuntimeException("No such code " + otpRequestDto.getOtpIdentifier()));
        if (oneTimePassword != null && LocalDateTime.now().isBefore(oneTimePassword.getExpiredDateTime())) {
            log.info("OTP validated");
            oneTimePassword.setOtpStatus(OTPStatus.USED);
            otpRepository.save(oneTimePassword);
        } else {
            throw new RuntimeException("OTP expired");
        }
    }
}
