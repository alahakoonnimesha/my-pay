package com.demo.mypay.api.dto;

import lombok.Data;


@Data
public class CounterDto {
    private String id;
    private String name;
    private ShopDto shopDto;
}
