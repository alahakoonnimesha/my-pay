package com.demo.mypay.service;

import com.demo.mypay.api.dto.OTPRequestDto;
import com.demo.mypay.api.dto.ResponseDto;

public interface OTPService {

    ResponseDto create(OTPRequestDto otpRequestDto);

    ResponseDto validate(OTPRequestDto otpRequestDto) throws RuntimeException;
}
