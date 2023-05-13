package com.demo.mypay.businessService.converter;

import com.demo.mypay.api.dto.PaymentRequestDto;
import com.demo.mypay.domain.Payment;
import com.demo.mypay.enums.PaymentStatus;
import com.demo.mypay.repository.CardRepository;
import com.demo.mypay.repository.CounterRepository;
import com.demo.mypay.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreatePayment {
    private final UserRepository userRepository;
    private final CardRepository cardRepository;
    private final CounterRepository counterRepository;


    public Payment convert(PaymentRequestDto paymentRequestDto) {
        Payment payment = new Payment();
        payment.setPaymentStatus(PaymentStatus.INITIATED);
        payment.setAmount(paymentRequestDto.getAmount());
        payment.setUser(userRepository.getById(paymentRequestDto.getUserId()));
        payment.setCard(cardRepository.getById(paymentRequestDto.getCardId()));
        payment.setCounter(counterRepository.getById(paymentRequestDto.getCounterId()));
        return payment;
    }
}
