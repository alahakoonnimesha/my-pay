package com.demo.mypay.service.impl;

import com.demo.mypay.api.dto.CounterDto;
import com.demo.mypay.api.dto.ResponseDto;
import com.demo.mypay.businessService.CounterBusinessService;
import com.demo.mypay.businessService.converter.CounterConverter;
import com.demo.mypay.service.CounterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CounterServiceImpl implements CounterService {
    private final CounterBusinessService counterBusinessService;
    private final CounterConverter counterConverter;

    @Override
    public ResponseDto get(String id) {
        CounterDto counterDto = counterConverter.convert(counterBusinessService.get(id));
        ResponseDto responseDto = new ResponseDto();
        responseDto.setData(counterDto);
        return responseDto;
    }

}
