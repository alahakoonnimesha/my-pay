package com.demo.mypay.service.impl;

import com.demo.mypay.api.dto.PaymentRequestDto;
import com.demo.mypay.api.dto.ResponseDto;
import com.demo.mypay.businessService.PaymentBusinessService;
import com.demo.mypay.businessService.converter.CreatePayment;
import com.demo.mypay.businessService.converter.PaymentConverter;
import com.demo.mypay.domain.Payment;
import com.demo.mypay.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final CreatePayment createPayment;
    private final PaymentBusinessService paymentBusinessService;
    private final PaymentConverter paymentConverter;


    @Override
    public ResponseDto create(PaymentRequestDto paymentRequestDto) {
        Payment payment = createPayment.convert(paymentRequestDto);
        paymentBusinessService.create(payment);
        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage("Payment Created");
        return responseDto;
    }

    @Override
    public ResponseDto getAll(String id) {
        List<Payment> payments = paymentBusinessService.getAll(id);
        ResponseDto responseDto = new ResponseDto();
        responseDto.setData(payments.stream().map(paymentConverter::convert).collect(Collectors.toList()));
        return responseDto;
    }
}
