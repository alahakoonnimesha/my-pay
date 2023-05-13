package com.demo.mypay.businessService.converter;

import com.demo.mypay.api.dto.MerchantDto;
import com.demo.mypay.domain.Merchant;
import org.springframework.stereotype.Component;

@Component
public class MerchantConverter {

    public MerchantDto convert(Merchant merchant) {
        MerchantDto merchantDto = new MerchantDto();
        merchantDto.setId(merchant.getId());
        merchantDto.setName(merchant.getName());
        return merchantDto;
    }
}
