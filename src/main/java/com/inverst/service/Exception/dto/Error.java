package com.inverst.service.Exception.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Error {

    private String code;
    private String message;
    private String errorDetails;

    public Error(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public Error(String code, String message, String errorDetails) {
        this.code = code;
        this.message = message;
        this.errorDetails = errorDetails;
    }
}
