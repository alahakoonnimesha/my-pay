package com.demo.mypay.api.dto;

import com.demo.mypay.enums.CardType;
import lombok.Data;

import java.time.LocalDate;


@Data
public class CardDto {
    private String id;
    private String userId;
    private UserDto userDto;
    private String cardName;
    private String cardNo;
    private String cvv;
    private LocalDate expires;
    private CardType cardType;




}
