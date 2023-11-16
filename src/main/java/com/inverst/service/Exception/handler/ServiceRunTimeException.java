package com.inverst.service.Exception.handler;

import com.inverst.service.Exception.response.ResponseMessage;

public class ServiceRuntimeException extends RuntimeException{

    public ResponseMessage responseMessage;

    public ServiceRuntimeException(String message, ResponseMessage responseMessage) {
        super(message);
        this.responseMessage = responseMessage;
    }

    public ServiceRuntimeException(ResponseMessage responseMessage) {
        super(responseMessage.getMessage());
        this.responseMessage = responseMessage;
    }

    public ResponseMessage getResponseMessage(){
        return responseMessage;
    }
}
