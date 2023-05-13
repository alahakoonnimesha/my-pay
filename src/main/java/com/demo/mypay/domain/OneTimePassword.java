package com.demo.mypay.domain;

import com.demo.mypay.enums.OTPStatus;
import com.demo.mypay.enums.OTPType;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

@Entity
@Data
public class OneTimePassword {
    @Id
    @GenericGenerator(name = "uuid", strategy = "uuid")
    @GeneratedValue(generator = "uuid")
    private String id;
    private String otpIdentifier;
    private String code;
    @Enumerated(EnumType.STRING)
    private OTPType otpType;
    private LocalDateTime createdDateTime;
    private LocalDateTime expiredDateTime;
    @Enumerated(EnumType.STRING)
    private OTPStatus otpStatus;

}
