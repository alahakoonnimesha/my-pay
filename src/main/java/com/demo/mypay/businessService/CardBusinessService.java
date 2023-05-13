package com.demo.mypay.businessService;

import com.demo.mypay.domain.Card;
import com.demo.mypay.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CardBusinessService {

    private final CardRepository cardRepository;

    public Card get(String id) {
        return cardRepository.getById(id);
    }

    public void create(Card card) {
        cardRepository.save(card);
    }
}
