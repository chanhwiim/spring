package com.nhnacademy.edu.springframework.service.impl;

import com.nhn.dooray.client.DoorayHook;
import com.nhn.dooray.client.DoorayHookSender;
import com.nhnacademy.edu.springframework.annotation.Dooray;
import com.nhnacademy.edu.springframework.domain.User;
import com.nhnacademy.edu.springframework.service.MessageSender;
import org.springframework.web.client.RestTemplate;

@Dooray("doorayMessageSender")
public class DoorayMessageSender implements MessageSender {
    private static final String uri = "https://hook.dooray.com/services/3204376758577275363/3727553265487230503/DIiyr9z0ROKJksd5yMFedQ";
    private DoorayHookSender doorayHookSender;

    public DoorayMessageSender(DoorayHookSender doorayHookSender) {
        this.doorayHookSender = doorayHookSender;
    }

    @Override
    public boolean sendMessage(User user, String message) {
        try {
            new DoorayHookSender(new RestTemplate(), uri)
                    .send(DoorayHook.builder()
                            .botName("???")
                            .text("???")
                            .build());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
