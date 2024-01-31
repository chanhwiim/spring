package com.nhnacademy.edu.springframework.service;

import com.nhnacademy.edu.springframework.domain.User;

public interface MessageSender {
    boolean sendMessage (User user, String message);
}
