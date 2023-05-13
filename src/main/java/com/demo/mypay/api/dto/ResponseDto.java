package com.demo.mypay.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDto {
    private int status;
    private String message;
    private Object data;
    private List<String> errors;

    public ResponseDto(int status, String commonError, List<String> errorList) {
        this.status = status;
        this.message = commonError;
        this.errors = errorList;


    }
}
