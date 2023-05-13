package com.demo.mypay.repository;

import com.demo.mypay.domain.OneTimePassword;
import com.demo.mypay.enums.OTPStatus;
import com.demo.mypay.enums.OTPType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OTPRepository extends JpaRepository<OneTimePassword, String> {
    List<OneTimePassword> findByOtpStatusAndOtpIdentifier(OTPStatus otpStatus, String phoneNo);

    Optional<OneTimePassword> findByOtpIdentifierAndCodeAndOtpStatusAndOtpType(String otpIdentifier, String code, OTPStatus created, OTPType otpType);
}
