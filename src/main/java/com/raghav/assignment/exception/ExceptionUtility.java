package com.raghav.assignment.exception;

import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

public class ExceptionUtility {

   /* final static String DEFAULT_CATEGORY = "Application Error";

    public static ErrorDetails buildErrorDetailsEntity(APIGenericException apiGenericException, WebRequest request) {

        ErrorDetails errorDetails = new ErrorDetails(apiGenericException.getMessage(), apiGenericException.getDetails(),
                apiGenericException.getErrorMessage(), apiGenericException.getLocalizedMessage());

        errorDetails.setRequestPath(MDC.get(request.getSessionId()));// need to get more details

        return errorDetails;
    }

    public static ErrorDetails buildFalloutException(Exception exception, WebRequest request) {

        ErrorDetails errorDetails = new ErrorDetails(exception.getMessage(), exception.getLocalizedMessage(),
                "inter-001", "NA");
        errorDetails.setRequestPath(MDC.get(request.getSessionId()));
        return errorDetails;
    }


    public static void enhanceAPIDataNotFoundExceptionErrorDetail(ErrorDetails errorDetails) {
        errorDetails.setCategory(DEFAULT_CATEGORY);
        errorDetails.setHttpStatus(HttpStatus.NOT_FOUND);
        errorDetails.setHttpStatusCode(HttpStatus.NOT_FOUND.value());
        errorDetails.setTimestamp(new Date());
        errorDetails.setTransactionId(MDC.get(errorDetails.getTransactionId()));
        errorDetails.setLevel("DataBase Lookup");
    }*/

}
