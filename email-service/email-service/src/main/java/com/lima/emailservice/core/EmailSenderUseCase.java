package com.lima.emailservice.core;

import com.lima.emailservice.exception.EmailServiceException;

public interface EmailSenderUseCase {

    void sendEmail(String to, String subject, String body) throws EmailServiceException;

}
