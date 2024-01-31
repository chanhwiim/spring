package com.nhnacademy.edu.springframework;

import com.nhnacademy.edu.springframework.domain.User;
import com.nhnacademy.edu.springframework.service.MessageSendService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    private static final String MESSAGE = "test message";

    public static void main(String[] args) {
        User user = new User("email", "phoneNumber");

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.nhnacademy.edu.springframework");
        MessageSendService messageSendService = context.getBean("messageSendService", MessageSendService.class);

        messageSendService.doSendMessage(user, MESSAGE);
    }
}