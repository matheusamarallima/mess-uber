package com.lima.emailservice.infra.awsses;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.*;
import com.lima.emailservice.adapters.EmailSenderGateway;
import com.lima.emailservice.exception.EmailServiceException;
import org.springframework.beans.factory.annotation.Autowired;

public class SesEmailSender implements EmailSenderGateway {

    private final AmazonSimpleEmailService amazonSimpleEmailService;

    @Autowired
    public SesEmailSender(AmazonSimpleEmailService amazonSimpleEmailService){
        this.amazonSimpleEmailService = amazonSimpleEmailService;
    }
    @Override
    public void sendEmail(String to, String subject, String body) throws EmailServiceException {
        SendEmailRequest request = new SendEmailRequest()
                .withSource("matheus@gmail.com")
                .withDestination(new Destination().withToAddresses(to))
                .withMessage(new Message().withSubject(new Content(subject))
                        .withBody(new Body().withText(new Content(body))));

        try{
            this.amazonSimpleEmailService.sendEmail(request);
        }catch (AmazonServiceException exception){
            throw new EmailServiceException("Failure while sending email", exception);
        }
    }

}