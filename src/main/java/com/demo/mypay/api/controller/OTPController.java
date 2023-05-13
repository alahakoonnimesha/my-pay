package com.demo.mypay.api.controller;

import com.demo.mypay.api.dto.OTPRequestDto;
import com.demo.mypay.api.dto.ResponseDto;
import com.demo.mypay.service.OTPService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/otp")
@RequiredArgsConstructor
@Slf4j
public class OTPController {
    private final OTPService otpService;

    @PostMapping
    public ResponseDto create(@RequestBody OTPRequestDto otpRequestDto) {
        return otpService.create(otpRequestDto);
    }

    @PutMapping
    public ResponseDto validate(@RequestBody OTPRequestDto otpRequestDto) {
        return otpService.validate(otpRequestDto);
    }


}
