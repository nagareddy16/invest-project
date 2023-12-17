package com.inverst.service.Exception.handler;

import com.inverst.service.Exception.response.ResponseMessage;

public class RunTimeServiceException extends RuntimeException{


    public ResponseMessage responseMessage;

    public RunTimeServiceException(String message, ResponseMessage responseMessage) {
        super(message);
        this.responseMessage = responseMessage;
    }

    public RunTimeServiceException(ResponseMessage responseMessage) {
        super(responseMessage.getMessage());
        this.responseMessage = responseMessage;
    }
}
