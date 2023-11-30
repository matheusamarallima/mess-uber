package com.lima.emailservice.application;

import com.lima.emailservice.adapters.EmailSenderGateway;
import com.lima.emailservice.core.EmailSenderUseCase;
import com.lima.emailservice.exception.EmailServiceException;
import org.springframework.beans.factory.annotation.Autowired;


public class EmailSenderService implements EmailSenderUseCase {

    private final EmailSenderGateway emailSenderGateway;

    @Autowired
    public EmailSenderService(EmailSenderGateway emailSenderGateway){
        this.emailSenderGateway = emailSenderGateway;
    }

    @Override
    public void sendEmail(String to, String subject, String body){
        this.emailSenderGateway.sendEmail(to, subject, body);
    }


}
