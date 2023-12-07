package com.inverst.service.Exception.handler;

import com.inverst.service.Exception.response.ResponseMessage;

public class ServicerunTimeException extends RuntimeException{

        public ResponseMessage responseMessage;

        public ServicerunTimeException(String message, ResponseMessage responseMessage) {
            super(message);
            this.responseMessage = responseMessage;
        }

        public ServicerunTimeException(ResponseMessage responseMessage) {
            super(responseMessage.getMessage());
            this.responseMessage = responseMessage;
        }

        public ResponseMessage getResponseMessage(){
            return responseMessage;
        }

}
