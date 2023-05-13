package com.demo.mypay.businessService.converter;

import com.demo.mypay.api.dto.CounterDto;
import com.demo.mypay.domain.Counter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CounterConverter {
    private final ShopConverter shopConverter;


    public CounterDto convert(Counter counter) {
        CounterDto counterDto = new CounterDto();
        counterDto.setId(counter.getId());
        counterDto.setName(counter.getName());
        counterDto.setShopDto(shopConverter.convert(counter.getShop()));
        return counterDto;
    }
}
