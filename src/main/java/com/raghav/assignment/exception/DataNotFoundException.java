package com.raghav.assignment.exception;

public class DataNotFoundException extends RuntimeException {

      private static final long serialVersionUID = 2577367231656399112L;

    public DataNotFoundException(String message) {
        super(message);
    }
}
