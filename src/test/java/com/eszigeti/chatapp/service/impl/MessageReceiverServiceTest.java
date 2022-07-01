package com.eszigeti.chatapp.service.impl;

import com.eszigeti.chatapp.model.Message;
import com.eszigeti.chatapp.service.MessageService;
import com.eszigeti.chatapp.service.NotificationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MessageReceiverServiceTest {

    private static final Message MESSAGE = new Message();
    private static final Message UPDATED_MESSAGE = new Message();

    private MessageService messageServiceMock;
    private NotificationService notificationServiceMock;
    private MessageReceiverService underTest;

    @BeforeEach
    private void setUp() {
        messageServiceMock = Mockito.mock(MessageService.class);
        notificationServiceMock = Mockito.mock(NotificationService.class);
        underTest = new MessageReceiverService(messageServiceMock, notificationServiceMock);
    }

    @Test
    public void onMessageShouldCallAllDependencies() {
        //GIVEN
        Mockito.when(messageServiceMock.updateMessage(MESSAGE)).thenReturn(UPDATED_MESSAGE);
        //WHEN
        underTest.onMessage(MESSAGE);
        //THEN
        Mockito.verify(notificationServiceMock, Mockito.times(1)).notifyReceiver(UPDATED_MESSAGE);
    }
}