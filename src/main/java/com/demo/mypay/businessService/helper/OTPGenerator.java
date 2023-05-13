package com.demo.mypay.businessService.helper;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
public class OTPGenerator {

    public String generateOTP() {
        SecureRandom random = new SecureRandom();
        int otp = random.nextInt(10000);
        String otpString = String.format("%04d", otp);
        return otpString;
    }
}
