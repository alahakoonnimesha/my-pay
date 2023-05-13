package com.demo.mypay.api.controller;

import com.demo.mypay.api.dto.PaymentRequestDto;
import com.demo.mypay.api.dto.ResponseDto;
import com.demo.mypay.service.PaymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/payments")
@Slf4j
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    public ResponseDto create(@RequestBody @Valid PaymentRequestDto paymentRequestDto) {
        return paymentService.create(paymentRequestDto);
    }

    @GetMapping("/{userId}")
    public ResponseDto getAll(@PathVariable String userId) {
        return paymentService.getAll(userId);
    }

}
