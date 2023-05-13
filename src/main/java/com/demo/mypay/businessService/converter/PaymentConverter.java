package com.demo.mypay.businessService.converter;

import com.demo.mypay.api.dto.PaymentDto;
import com.demo.mypay.domain.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentConverter {
    private final UserConverter userConverter;
    private final CardConverter cardConverter;
    private final CounterConverter counterConverter;


    public PaymentDto convert(Payment payment) {
        PaymentDto paymentDto = new PaymentDto();
        paymentDto.setId(payment.getId());
        paymentDto.setAmount(payment.getAmount());
        paymentDto.setPaymentStatus(payment.getPaymentStatus());
        paymentDto.setUserDto(userConverter.convert(payment.getUser()));
        paymentDto.setCardDto(cardConverter.convert(payment.getCard()));
        paymentDto.setCounterDto(counterConverter.convert(payment.getCounter()));
        return paymentDto;
    }
}
