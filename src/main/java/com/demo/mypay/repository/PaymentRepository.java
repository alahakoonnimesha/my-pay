package com.demo.mypay.repository;

import com.demo.mypay.domain.Card;
import com.demo.mypay.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, String> {
    List<Payment> findAllByUserId(String userId);
}