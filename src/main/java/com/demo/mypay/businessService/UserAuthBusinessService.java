package com.demo.mypay.businessService;

import com.demo.mypay.domain.UserAuthentication;
import com.demo.mypay.repository.UserAuthRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.StringEncryptor;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserAuthBusinessService {

    private final UserAuthRepository userAuthRepository;
    private final StringEncryptor encryptor;


    public UserAuthentication create(UserAuthentication userAuth) {
        userAuth.setPassword(encryptor.encrypt(userAuth.getPassword()));
        return userAuthRepository.save(userAuth);
    }
}








































