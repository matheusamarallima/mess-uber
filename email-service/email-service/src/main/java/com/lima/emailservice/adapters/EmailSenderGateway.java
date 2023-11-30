package com.lima.emailservice.adapters;

import com.lima.emailservice.exception.EmailServiceException;

public interface EmailSenderGateway {

    void sendEmail(String to, String subject, String body) throws EmailServiceException;
}
