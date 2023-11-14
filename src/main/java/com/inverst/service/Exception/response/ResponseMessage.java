package com.inverst.service.Exception.response;

import org.springframework.http.HttpStatus;

public enum ResponseMessage {
    DATA_NOT_FOUND(HttpStatus.NOT_FOUND,"1049", "No Data Found");


    private String code;

    private String message;

    private HttpStatus httpStatus;

    ResponseMessage(HttpStatus httpStatus,String code, String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
