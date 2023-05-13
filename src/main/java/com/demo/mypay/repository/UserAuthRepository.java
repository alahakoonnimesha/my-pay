package com.demo.mypay.repository;

import com.demo.mypay.domain.UserAuthentication;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserAuthRepository extends JpaRepository<UserAuthentication, String> {
}