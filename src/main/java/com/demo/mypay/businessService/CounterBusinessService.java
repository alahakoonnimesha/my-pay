package com.demo.mypay.businessService;

import com.demo.mypay.domain.Counter;
import com.demo.mypay.repository.CounterRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CounterBusinessService {

    private final CounterRepository counterRepository;

    public Counter get(String id) {
        return counterRepository.getById(id);
    }
}
