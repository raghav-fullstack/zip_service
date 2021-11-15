package com.raghav.assignment.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class APIGenericException extends RuntimeException{

    private static final long serialVersionID = 1L;

    String errorMessage;
    String details;
    String applicationErrorCode;
    String processingTier;


    public APIGenericException(String errorMessage, String details, String applicationErrorCode, String processingTier) {

        super();
        this.errorMessage = errorMessage;
        this.details = details;
        this.applicationErrorCode = applicationErrorCode;
        this.processingTier = processingTier;
    }
}
