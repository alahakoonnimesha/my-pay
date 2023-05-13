package com.demo.mypay.domain;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;


@Data
@Entity
public class Merchant {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String name;
    @OneToMany(mappedBy = "merchant", cascade = CascadeType.ALL)
    private Set<Shop> shops;
}
