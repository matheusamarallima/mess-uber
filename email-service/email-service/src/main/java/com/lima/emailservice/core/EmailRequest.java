package com.lima.emailservice.core;

public record EmailRequest(String to, String subject, String body) {
}
