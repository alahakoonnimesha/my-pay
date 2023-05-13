package com.demo.mypay.api.controller;

import com.demo.mypay.api.dto.*;
import com.demo.mypay.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/users")
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseDto create(@RequestBody UserAuthDto userDto) {
        return userService.create(userDto);
    }

    @GetMapping("/{id}")
    public ResponseDto get(@PathVariable String id) {
        return userService.get(id);
    }

    @PutMapping
    public ResponseDto update(@RequestBody UserAuthDto userDto) {
        return userService.update(userDto);
    }

    @GetMapping("/filter")
    public ResponseDto filter(@RequestParam(required = false) String phoneNo,@RequestParam(required = false) LocalDate date) {
        long startTime = System.currentTimeMillis();
        ResponseDto responseDto = userService.filter(phoneNo,date);
        log.info("time taken "+ (System.currentTimeMillis()- startTime));
        return responseDto;
    }

}
