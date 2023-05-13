package com.demo.mypay.domain;

import com.demo.mypay.enums.CardType;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;


@Data
@Entity
public class Card {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    private String cardName;
    private String cardNo;
    private String cvv;
    private LocalDate expires;
    @Enumerated(EnumType.STRING)
    private CardType cardType;


}
