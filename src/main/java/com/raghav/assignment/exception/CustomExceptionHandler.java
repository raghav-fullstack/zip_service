package com.raghav.assignment.exception;

import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DataNotFoundException.class)
    public final ResponseEntity<ErrorDetails> handleAlLException(RuntimeException runtimeException, HttpServletRequest request){

        DataNotFoundException dataNotFoundException = (DataNotFoundException) runtimeException;
            ErrorDetails errorDetails = ErrorDetails.builder().code(HttpStatus.NOT_FOUND.value()).errorMessage(dataNotFoundException.getMessage())
                    .transactionId(MDC.get("transactionId")).path(request.getRequestURI()).timestamp(new Date()).build();

        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

   @ExceptionHandler(InvalidArgumentException.class)
    public final ResponseEntity<ErrorDetails> missingArgumentParameterException(RuntimeException runtimeException, HttpServletRequest request){

       InvalidArgumentException invalidArgumentException = (InvalidArgumentException) runtimeException;

        ErrorDetails errorDetails = ErrorDetails.builder().code(HttpStatus.BAD_REQUEST.value()).errorMessage(invalidArgumentException.getMessage())
                .transactionId(MDC.get("transactionId")).path(request.getRequestURI()).timestamp(new Date()).build();

        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }


}
