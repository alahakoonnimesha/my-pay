package com.demo.mypay.service;

import com.demo.mypay.api.dto.CounterDto;
import com.demo.mypay.api.dto.ResponseDto;
import com.demo.mypay.api.dto.UserAuthDto;

public interface CounterService {
    ResponseDto get(String id);
}
