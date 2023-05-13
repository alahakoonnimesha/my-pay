package com.demo.mypay.api.dto;

import com.demo.mypay.enums.OTPType;
import lombok.Data;

@Data
public class OTPRequestDto {
    private String otpIdentifier;
    private String code;
    private OTPType otpType;


}
