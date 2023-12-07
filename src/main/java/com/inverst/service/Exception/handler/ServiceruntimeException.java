package com.inverst.service.Exception.handler;

import com.inverst.service.Exception.response.ResponseMessage;

public class ServiceruntimeException extends RuntimeException{

    public ResponseMessage responseMessage;

    public ServiceruntimeException(String message, ResponseMessage responseMessage) {
        super(message);
        this.responseMessage = responseMessage;
    }

    public ServiceruntimeException(ResponseMessage responseMessage) {
        super(responseMessage.getMessage());
        this.responseMessage = responseMessage;
    }

    public ResponseMessage getResponseMessage(){
        return responseMessage;
    }
}
