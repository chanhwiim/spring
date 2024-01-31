package com.nhnacademy.edu.springframework;

import com.nhnacademy.edu.springframework.domain.User;
import com.nhnacademy.edu.springframework.service.MessageSender;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    private static final String MESSAGE = "test message";

    public static void main(String[] args) {
        User user = new User("email", "phoneNumber");

        try(ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml")) {
            MessageSender dooray = context.getBean("doorayMessageSender", MessageSender.class);

            dooray.sendMessage(user, MESSAGE);
        }
    }
}