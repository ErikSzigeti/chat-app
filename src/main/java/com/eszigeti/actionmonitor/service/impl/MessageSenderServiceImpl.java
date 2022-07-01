package com.eszigeti.actionmonitor.service.impl;

import com.eszigeti.actionmonitor.model.Message;
import com.eszigeti.actionmonitor.service.MessageSenderService;
import com.eszigeti.actionmonitor.service.MessageService;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageSenderServiceImpl implements MessageSenderService {

    private final JmsTemplate jmsTemplate;
    private final MessageService messageService;

    public MessageSenderServiceImpl(JmsTemplate jmsTemplate, MessageService messageService) {
        this.jmsTemplate = jmsTemplate;
        this.messageService = messageService;
    }

    @Override
    public void sendMessage(long senderId, long receiverId, Message message) {
        Message savedMessage = messageService.saveMessage(senderId, receiverId, message);
        sendMessage(savedMessage);
    }

    private void sendMessage(final Message message) {
        jmsTemplate.convertAndSend(message);
    }

}
