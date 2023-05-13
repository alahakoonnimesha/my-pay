package com.demo.mypay.businessService.converter;

import com.demo.mypay.api.dto.CardDto;
import com.demo.mypay.domain.Card;
import lombok.RequiredArgsConstructor;
import org.jasypt.encryption.StringEncryptor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CardConverter {
    private final UserConverter userConverter;
    private final StringEncryptor encryptor;


    public CardDto convert(Card card) {
        CardDto cardDto = new CardDto();
        cardDto.setId(card.getId());
        cardDto.setCardName(card.getCardName());
        cardDto.setCardNo(encryptor.decrypt(card.getCardNo()));
        cardDto.setCvv(encryptor.decrypt(card.getCvv()));
        cardDto.setExpires(card.getExpires());
        cardDto.setCardType(card.getCardType());
        cardDto.setUserDto(userConverter.convert(card.getUser()));
        return cardDto;
    }

    public Card convert(CardDto cardDto) {
        Card card = new Card();
        card.setId(cardDto.getId());
        card.setCardName(cardDto.getCardName());
        card.setCardNo(encryptor.encrypt(cardDto.getCardNo()));
        card.setCvv(encryptor.encrypt(cardDto.getCvv()));
        card.setExpires(cardDto.getExpires());
        card.setCardType(cardDto.getCardType());
        return card;
    }
}
