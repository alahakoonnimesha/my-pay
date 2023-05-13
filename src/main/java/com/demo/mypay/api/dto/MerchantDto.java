package com.demo.mypay.api.dto;

import lombok.Data;

import java.util.Set;


@Data
public class MerchantDto {
    private String id;
    private String name;
    private Set<ShopDto> shopDtos;
}
