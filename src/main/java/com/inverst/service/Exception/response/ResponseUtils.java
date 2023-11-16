package com.inverst.service.Exception.response;

import com.inverst.service.Exception.dto.Error;
import org.springframework.http.ResponseEntity;

public class ResponseUtils {


    public static ResponseEntity createResponse(ResponseMessage responseMessage) {
        return new ResponseEntity<>(responseMessage.getMessage(), responseMessage.getHttpStatus());
    }

}
