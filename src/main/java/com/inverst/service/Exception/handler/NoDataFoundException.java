package com.inverst.service.Exception.handler;

import com.inverst.service.Exception.response.ResponseMessage;

public class NoDataFoundException extends RuntimeException{

    public final ResponseMessage responseMessage;

    public NoDataFoundException(ResponseMessage responseMessage) {
        super(responseMessage.getMessage());
        this.responseMessage = responseMessage;
    }


    public NoDataFoundException(String message, ResponseMessage responseMessage) {
        super(message);
        this.responseMessage = responseMessage;
    }

    public NoDataFoundException() {
        super(ResponseMessage.DATA_NOT_FOUND.getMessage());
        this.responseMessage = ResponseMessage.DATA_NOT_FOUND;
    }

    public ResponseMessage getResponseMessage(){
        return responseMessage;
    }


}
