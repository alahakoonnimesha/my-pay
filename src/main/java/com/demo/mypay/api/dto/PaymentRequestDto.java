package com.demo.mypay.api.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.math.BigDecimal;


@Data
public class PaymentRequestDto {
    @NotBlank(message = "User id required")
    private String userId;
    @NotBlank(message = "Card id required")
    private String cardId;
    @NotBlank(message = "Counter id required")
    private String counterId;
    private BigDecimal amount;
}
