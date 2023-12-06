package com.inverst.service.Exception.dto;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ExceptionDetails {

    private String requestId;
    private String stackTrace;
    private String className;
    private String methodName;
    private String message;
}
