package com.inverst.service.Exception.handler;


import com.inverst.service.Exception.dto.Error;
import com.inverst.service.Exception.response.ResponseMessage;
import com.inverst.service.Exception.response.ResponseUtils;
import com.inverst.service.utils.CommonUtils;
import com.inverst.service.utils.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {


    @Autowired
    private Environment environment;


    @ExceptionHandler(NoSuchElementException.class)
    public final ResponseEntity<Error> handleNoSuchElementException(NoSuchElementException noSuchElementException){
        Error error = new Error(ResponseMessage.NO_VALUE_PRESENT.getCode(),
                ResponseMessage.NO_VALUE_PRESENT.getMessage());

        LogUtils.logExceptionDetails(noSuchElementException);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ServiceruntimeException.class)
    public final ResponseEntity<Error> handleServiceRunTimeException(ServiceruntimeException exception){
        Error error = new Error(exception.responseMessage.getCode(), exception.responseMessage.getMessage());
        if(exception.responseMessage.getHttpStatus().is2xxSuccessful()){
            return ResponseUtils.createResponse(exception.responseMessage);
        }
        LogUtils.logExceptionDetails(exception);
        return new ResponseEntity<>(error, exception.responseMessage.getHttpStatus());
    }

    @ExceptionHandler(NoDataFoundException.class)
    public final ResponseEntity<Error> handleNoDataFoundException(NoDataFoundException exception){
        return new ResponseEntity<>(new Error(exception.responseMessage.getCode(),
                exception.responseMessage.getMessage()), exception.responseMessage.getHttpStatus());
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<Error> handleAllExceptions(Exception exception){
        Error error;
        if(CommonUtils.isProduction(environment)){
            error = new Error(ResponseMessage.APPLICATION_ERROR.getCode(),
                    ResponseMessage.APPLICATION_ERROR.getMessage());
        }else {
            error = new Error(ResponseMessage.APPLICATION_ERROR.getCode(),
                    ResponseMessage.APPLICATION_ERROR.getMessage());
        }
        LogUtils.logExceptionDetails(exception);
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
