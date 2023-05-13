package com.demo.mypay.businessService;

import com.demo.mypay.businessService.converter.OTPConverter;
import com.demo.mypay.domain.User;
import com.demo.mypay.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class UserBusinessService {

    private final UserRepository userRepository;
    private final OTPConverter otpConverter;

    public User create(User user) {
        return userRepository.save(user);
    }

    public User get(String id) {
        return userRepository.getById(id);
    }

    public User getByPhoneNo(String phoneNo) {
        return userRepository.findByPhoneNo(phoneNo).orElse(null);

    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
}
