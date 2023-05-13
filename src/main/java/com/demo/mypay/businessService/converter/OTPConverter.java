package com.demo.mypay.businessService.converter;

import com.demo.mypay.api.dto.OTPRequestDto;
import com.demo.mypay.businessService.helper.OTPGenerator;
import com.demo.mypay.domain.OneTimePassword;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class OTPConverter {
    @Value("${otp.timeout.minutes}")
    private int otpTimeoutMinutes;
    private final OTPGenerator otpGenerator;


    public OneTimePassword convert(OTPRequestDto otpRequestDto) {
        OneTimePassword oneTimePassword = new OneTimePassword();
        oneTimePassword.setOtpIdentifier(otpRequestDto.getOtpIdentifier());
        oneTimePassword.setOtpType(otpRequestDto.getOtpType());
        oneTimePassword.setCode(otpGenerator.generateOTP());
        oneTimePassword.setCreatedDateTime(LocalDateTime.now());
        oneTimePassword.setExpiredDateTime(LocalDateTime.now().plusSeconds(otpTimeoutMinutes * 60L));
        return oneTimePassword;
    }
}
