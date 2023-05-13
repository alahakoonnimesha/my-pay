package com.demo.mypay.api.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Data
public class UserDto {
    private String id;
    private String phoneNo;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private LocalDateTime registeredDateTime;
    private Boolean deleted;
}
