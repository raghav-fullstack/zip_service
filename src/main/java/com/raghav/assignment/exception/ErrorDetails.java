package com.raghav.assignment.exception;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Data
@Builder
public class ErrorDetails {

    private Date timestamp;
    private String errorMessage;
    private String transactionId;
    private int code;
    private String path;
}