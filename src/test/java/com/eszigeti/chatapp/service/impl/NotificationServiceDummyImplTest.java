package com.eszigeti.chatapp.service.impl;

import com.eszigeti.chatapp.model.Message;
import com.eszigeti.chatapp.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NotificationServiceDummyImplTest {

    private Message defaultMessage;


    private NotificationServiceDummyImpl underTest;

    @BeforeEach
    private void setUp() {
        defaultMessage = new Message();
        User defaultUser = new User();
        defaultUser.setId(1L);
        defaultMessage.setReceiver(defaultUser);

        underTest = new NotificationServiceDummyImpl();
    }

    @Test
    public void notifyReceiverShouldNotThrowExceptionWhenCalled() {
        Assertions.assertDoesNotThrow(() -> underTest.notifyReceiver(defaultMessage));
    }
}