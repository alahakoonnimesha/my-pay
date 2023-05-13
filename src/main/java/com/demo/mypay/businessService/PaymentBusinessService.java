package com.demo.mypay.businessService;

import com.demo.mypay.domain.Payment;
import com.demo.mypay.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PaymentBusinessService {

    private final PaymentRepository paymentRepository;

    public Payment create(Payment payment) {
        return paymentRepository.save(payment);
    }

    public Payment get(String id) {
        return paymentRepository.getById(id);
    }

    public List<Payment> getAll(String userId) {
        return paymentRepository.findAllByUserId(userId);
    }
}
