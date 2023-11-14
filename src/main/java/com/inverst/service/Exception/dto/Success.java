package com.inverst.service.Exception.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Success {

    private String id;
    private String code;
    private String message;
    private Integer noOfRecordsUpdated;


}
