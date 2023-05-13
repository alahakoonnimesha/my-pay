package com.demo.mypay.service;

import com.demo.mypay.api.dto.OTPRequestDto;
import com.demo.mypay.api.dto.ResponseDto;
import com.demo.mypay.api.dto.UserAuthDto;
import com.demo.mypay.api.dto.UserDto;

import java.time.LocalDate;

public interface UserService {

    ResponseDto create(UserAuthDto userDto);

    ResponseDto get(String id);

    ResponseDto update(UserAuthDto userDto);

    ResponseDto filter(String phoneNo, LocalDate date);
}
