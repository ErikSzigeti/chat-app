package com.eszigeti.chatapp.service.impl;

import com.eszigeti.chatapp.model.Message;
import com.eszigeti.chatapp.service.MessageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.jms.core.JmsTemplate;

class MessageSenderServiceImplTest {

    private static final Message MESSAGE = new Message();
    private static final Message SAVED_MESSAGE = new Message();
    private static final long SENDER_ID = 1L;
    private static final long RECEIVER_ID = 2L;

    private  JmsTemplate jmsTemplateMock;
    private  MessageService messageServiceMock;
    private MessageSenderServiceImpl underTest;

    @BeforeEach
    private void setUp() {
        jmsTemplateMock = Mockito.mock(JmsTemplate.class);
        messageServiceMock = Mockito.mock(MessageService.class);
        underTest = new MessageSenderServiceImpl(jmsTemplateMock, messageServiceMock);
    }

    @Test
    public void sendMessageShouldCallAllDependencies() {
        //GIVEN
        Mockito.when(messageServiceMock.saveMessage(SENDER_ID, RECEIVER_ID, MESSAGE)).thenReturn(SAVED_MESSAGE);
        //WHEN
        underTest.sendMessage(SENDER_ID, RECEIVER_ID, MESSAGE);
        //THEN
        Mockito.verify(messageServiceMock, Mockito.times(1)).saveMessage(SENDER_ID, RECEIVER_ID, MESSAGE);
        Mockito.verify(jmsTemplateMock, Mockito.times(1)).convertAndSend(SAVED_MESSAGE);
    }

}