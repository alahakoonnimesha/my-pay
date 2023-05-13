package com.demo.mypay.businessService.converter;

import com.demo.mypay.api.dto.ShopDto;
import com.demo.mypay.domain.Shop;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ShopConverter {

    private final MerchantConverter merchantConverter;

    public ShopDto convert(Shop shop) {
        ShopDto shopDto = new ShopDto();
        shopDto.setId(shop.getId());
        shopDto.setName(shop.getName());
        shopDto.setMerchantDto(merchantConverter.convert(shop.getMerchant()));
        return shopDto;
    }
}
