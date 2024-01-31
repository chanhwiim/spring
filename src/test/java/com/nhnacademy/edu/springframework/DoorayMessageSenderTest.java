package com.nhnacademy.edu.springframework;

import com.nhn.dooray.client.DoorayHookSender;
import com.nhnacademy.edu.springframework.domain.User;
import com.nhnacademy.edu.springframework.service.impl.DoorayMessageSender;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

public class DoorayMessageSenderTest {

    @Mock
    private DoorayHookSender doorayHookSender;

    @InjectMocks
    private DoorayMessageSender messageSender;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSendMessage() {
        User user = new User("email", "phoneNumber");
        String message = "test message";

        verify(doorayHookSender, times(0)).send(any());
    }
}
