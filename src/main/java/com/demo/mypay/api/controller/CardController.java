package com.demo.mypay.api.controller;

import com.demo.mypay.api.dto.CardDto;
import com.demo.mypay.api.dto.ResponseDto;
import com.demo.mypay.service.CardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cards")
@Slf4j
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;

    @PostMapping
    public ResponseDto create(@RequestBody CardDto cardDto) {
        return cardService.create(cardDto);
    }


    @GetMapping("/{id}")
    public ResponseDto get(@PathVariable String id) {
        return cardService.get(id);
    }

    @PutMapping
    public ResponseDto update(@RequestBody CardDto cardDto) {
        return cardService.update(cardDto);
    }

}
