package com.inverst.service.utils;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inverst.service.Exception.dto.Error;
import com.inverst.service.Exception.dto.ExceptionDetails;
import com.inverst.service.Exception.response.ResponseMessage;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.MDC;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class LogUtils {

    private LogUtils() {
    }


    public static void logAsyncError(String error){
        Map<String, Object> responseLog = new HashMap<>();
        responseLog.put("error_details", error);
        log.error(error);
    }

    public static void logExceptionDetails(Exception exception){
        if(null != exception){
            Map<String, Object> responseLog = new HashMap<>();
            ExceptionDetails exceptionDetails = getExceptionDetails(exception);
            responseLog.put("Exception", exceptionDetails.getStackTrace());
            responseLog.put("Message", exceptionDetails.getMessage());
            log.error(mapToString(responseLog));
        }

    }


    public static void logMessage(String function, String operation, String message){
        Map<String, Object> responseLog = new HashMap<>();
        responseLog.put("body", message);
        responseLog.put("operation", operation);
        responseLog.put("function", function);
        log.error(mapToString(responseLog));
    }

    private static String mapToString(Map<String, Object> responseLog) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(responseLog);
        }catch(JsonProcessingException e){
            log.error(e.getMessage(), e);
        }
        return null;
    }

    public static void customExceptionDetails(Exception exception, Error error){
        if(null != exception){
            Map<String, Object> responseLog = new HashMap<>();
            ExceptionDetails exceptionDetails = getExceptionDetails(exception);
            responseLog.put("Exception", exceptionDetails.getStackTrace());
            responseLog.put("Message", error.getMessage());
            responseLog.put("Code", error.getCode());
        }
    }

    public static ExceptionDetails getExceptionDetails(Exception exception) {
        ExceptionDetails exceptionDetails = null;
        String requestId = StringUtils.isEmpty(MDC.get(Constant.REQUEST_ID)) ? MDC.get(Constant.REQUEST_ID) : Constant.UNDEFINED;
        if(null != exception.getStackTrace() && null != exception.getStackTrace()[0]){
            exceptionDetails = new ExceptionDetails();
            exceptionDetails.setRequestId(exceptionDetails.getRequestId());
            exceptionDetails.setStackTrace(Arrays.toString(exception.getStackTrace()));
            exceptionDetails.setClassName(exception.getStackTrace()[0].getClassName());
            exceptionDetails.setMethodName(exception.getStackTrace()[0].getMethodName());
            exceptionDetails.setMessage(exception.getMessage());
        }else{
            exceptionDetails = new ExceptionDetails();
            exceptionDetails.setRequestId(requestId);
            exceptionDetails.setStackTrace(Constant.UNDEFINED);
            exceptionDetails.setClassName(Constant.UNDEFINED);
            exceptionDetails.setMethodName(Constant.UNDEFINED);
            exceptionDetails.setMessage(Constant.UNDEFINED);
        }
        return  exceptionDetails;
    }

    public static void logeError(String methodName, Class<?> clazz, Exception e, ResponseMessage responseMessage){
        log.error("Exception caught inside"+clazz.getName()+"."+methodName+" :: "+ "Error msg :: "+ ExceptionUtils.getMessage(e)+" :: Error reason ::"+responseMessage);
    }
}
