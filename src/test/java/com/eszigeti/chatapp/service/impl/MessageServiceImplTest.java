package com.eszigeti.chatapp.service.impl;

import com.eszigeti.chatapp.model.Message;
import com.eszigeti.chatapp.model.MessageStatus;
import com.eszigeti.chatapp.model.User;
import com.eszigeti.chatapp.repository.MessageRepository;
import com.eszigeti.chatapp.service.UserService;
import com.eszigeti.chatapp.service.util.TimeUtilService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.when;

class MessageServiceImplTest {

    private static final LocalDateTime LOCAL_DATE_TIME = LocalDateTime.of(2022, 12, 12, 6, 1);
    private static final long SENDER_ID = 1L;
    private static final long RECEIVER_ID = 2L;
    private static final User USER_SENDER = new User();
    private static final User USER_RECEIVER = new User();
    private Message messageDefault;

    private MessageRepository messageRepositoryMock;
    private UserService userServiceMock;
    private MessageServiceImpl underTest;

    @BeforeEach
    private void setUp() {
        messageDefault = new Message();
        messageRepositoryMock = Mockito.mock(MessageRepository.class);
        userServiceMock = Mockito.mock(UserService.class);
        TimeUtilService timeUtilServiceMock = Mockito.mock(TimeUtilService.class);
        underTest = new MessageServiceImpl(messageRepositoryMock, userServiceMock, timeUtilServiceMock);

        when(timeUtilServiceMock.getCurrentTime()).thenReturn(LOCAL_DATE_TIME);
    }

    @Test
    public void saveMessageShouldReturnExpectedMessageWhenCalled() {
        //GIVEN
        Message updatedMessage = new Message();
        updatedMessage.setSender(USER_SENDER);
        updatedMessage.setReceiver(USER_RECEIVER);
        updatedMessage.setTimestamp(LOCAL_DATE_TIME);
        updatedMessage.setStatus(MessageStatus.SENT);
        Message savedMessage = new Message();

        when(userServiceMock.getUser(SENDER_ID)).thenReturn(USER_SENDER);
        when(userServiceMock.getUser(RECEIVER_ID)).thenReturn(USER_RECEIVER);
        when(messageRepositoryMock.save(updatedMessage)).thenReturn(savedMessage);
        //WHEN
        Message actual = underTest.saveMessage(SENDER_ID, RECEIVER_ID, messageDefault);
        //THEN
        Assertions.assertEquals(savedMessage, actual);
    }

    @Test
    public void getMessagesShouldReturnValidListOfMessages() {
        //GIVEN
        List<Message> expectedMessages = List.of(messageDefault, messageDefault);
        when(messageRepositoryMock.findAllMessagesBetweenUsers(SENDER_ID, RECEIVER_ID)).thenReturn(expectedMessages);
        //WHEN
        List<Message> actual = underTest.getMessages(SENDER_ID, RECEIVER_ID);
        //THEN
        Assertions.assertEquals(expectedMessages, actual);
    }

    @Test
    public void updateMessageShouldReturnTheUpdatedMessageWhenCalled() {
        //GIVEN
        Message updatedMessage = new Message();
        updatedMessage.setTimestamp(LOCAL_DATE_TIME);
        updatedMessage.setStatus(MessageStatus.RECEIVED);
        Message expectedMessage = new Message();

        when(messageRepositoryMock.save(updatedMessage)).thenReturn(expectedMessage);
        //WHEN
        Message actual = underTest.updateMessage(messageDefault);
        //THEN
        Assertions.assertEquals(expectedMessage, actual);
    }


}