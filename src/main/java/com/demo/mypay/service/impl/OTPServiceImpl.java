package com.demo.mypay.service.impl;

import com.demo.mypay.api.dto.OTPRequestDto;
import com.demo.mypay.api.dto.ResponseDto;
import com.demo.mypay.businessService.OTPBusinessService;
import com.demo.mypay.service.OTPService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OTPServiceImpl implements OTPService {
    private final OTPBusinessService otpBusinessService;

    @Override
    public ResponseDto create(OTPRequestDto otpRequestDto) {
        otpBusinessService.createAndSend(otpRequestDto);
        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage("Otp Created");
        return responseDto;
    }

    @Override
    public ResponseDto validate(OTPRequestDto otpRequestDto) throws RuntimeException {
        otpBusinessService.validate(otpRequestDto);
        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage("Otp Validated");
        return responseDto;
    }
}
