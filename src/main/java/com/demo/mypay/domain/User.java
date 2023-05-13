package com.demo.mypay.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;


@Data
@Entity
public class User {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String phoneNo;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private LocalDateTime registeredDateTime;
    private Boolean deleted;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Card> cards;
}
