package com.eszigeti.actionmonitor.service.impl;

import com.eszigeti.actionmonitor.model.Message;
import com.eszigeti.actionmonitor.model.MessageStatus;
import com.eszigeti.actionmonitor.repository.MessageRepository;
import com.eszigeti.actionmonitor.service.MessageService;
import com.eszigeti.actionmonitor.service.UserService;
import com.eszigeti.actionmonitor.service.util.TimeUtilService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;
    private final UserService userService;
    private final TimeUtilService timeUtilService;

    public MessageServiceImpl(MessageRepository messageRepository, UserService userService, TimeUtilService timeUtilService) {
        this.messageRepository = messageRepository;
        this.userService = userService;
        this.timeUtilService = timeUtilService;
    }

    @Override
    public Message saveMessage(final long sender, final long receiver, final Message message) {
        updateMessageData(sender, receiver, message);
        return messageRepository.save(message);
    }

    @Override
    public List<Message> getMessages(long firstUserId, long secondUserId) {
        return messageRepository.findAllMessagesBetweenUsers(firstUserId, secondUserId);
    }

    @Override
    public Message updateMessage(Message message) {
        message.setStatus(MessageStatus.RECEIVED);
        message.setTimestamp(timeUtilService.getCurrentTime());
        return messageRepository.save(message);
    }

    private void updateMessageData(long sender, long receiver, Message message) {
        message.setSender(userService.getUser(sender));
        message.setReceiver(userService.getUser(receiver));
        message.setTimestamp(timeUtilService.getCurrentTime());
        message.setStatus(MessageStatus.SENT);
    }
}
