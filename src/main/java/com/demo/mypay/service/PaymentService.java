package com.demo.mypay.service;

import com.demo.mypay.api.dto.PaymentRequestDto;
import com.demo.mypay.api.dto.ResponseDto;
import com.demo.mypay.api.dto.UserAuthDto;

public interface PaymentService {
    ResponseDto create(PaymentRequestDto paymentRequestDto);

    ResponseDto getAll(String id);
}
