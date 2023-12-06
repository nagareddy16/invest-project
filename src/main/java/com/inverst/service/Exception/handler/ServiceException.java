package com.inverst.service.Exception.handler;

public class ServiceException extends RuntimeException{

    public ServiceException(String message) {
        super(message);
    }
}
