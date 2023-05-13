package com.demo.mypay.api.dto;

import lombok.Data;

@Data
public class UserAuthDto {
    private String password;
    private UserDto userDto;
}
