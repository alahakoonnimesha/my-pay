package com.demo.mypay.api.controller;

import com.demo.mypay.api.dto.ResponseDto;
import com.demo.mypay.service.CounterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/counters")
@Slf4j
@RequiredArgsConstructor
public class CounterController {

    private final CounterService counterService;

    @GetMapping("/{id}")
    public ResponseDto get(@PathVariable String id) {
        return counterService.get(id);
    }

}
