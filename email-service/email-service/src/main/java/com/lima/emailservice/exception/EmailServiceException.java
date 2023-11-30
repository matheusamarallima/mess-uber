package com.lima.emailservice.exception;

public class EmailServiceException extends Exception{
    public EmailServiceException(String message){
        super(message);
    }

    public EmailServiceException(String message, Throwable cause){
        super(message, cause);
    }
}
