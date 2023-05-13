package com.demo.mypay.api.dto;

import lombok.Data;

import java.util.Set;


@Data
public class ShopDto {
    private String id;
    private String name;
    private MerchantDto merchantDto;
    private Set<CounterDto> counterDtos;
}
