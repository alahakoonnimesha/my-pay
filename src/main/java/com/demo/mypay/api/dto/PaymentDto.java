package com.demo.mypay.api.dto;

import com.demo.mypay.enums.PaymentStatus;
import lombok.Data;

import java.math.BigDecimal;


@Data
public class PaymentDto {
    private String id;
    private UserDto userDto;
    private CardDto cardDto;
    private CounterDto counterDto;
    private BigDecimal amount;
    private PaymentStatus paymentStatus;

}
