package com.demo.mypay.service;

import com.demo.mypay.api.dto.CardDto;
import com.demo.mypay.api.dto.ResponseDto;

public interface CardService {
    ResponseDto get(String id);

    ResponseDto create(CardDto cardDto);

    ResponseDto update(CardDto cardDto);

    default void run() {
        System.out.println("The vehicle is running.");
        move();
    }

    private void move() {
        System.out.println("The vehicle is moving.");
    }
}

