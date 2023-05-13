package com.demo.mypay.api.dto;

import com.demo.mypay.domain.User;
import lombok.Data;

@Data
public class OneTimePasswordDto {
    private String id;
    private String password;
    private User userId;

}
