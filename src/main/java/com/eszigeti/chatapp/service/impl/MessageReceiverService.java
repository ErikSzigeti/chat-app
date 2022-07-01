package com.eszigeti.chatapp.service.impl;

import com.eszigeti.chatapp.configuration.mq.ActiveMQConfig;
import com.eszigeti.chatapp.model.Message;
import com.eszigeti.chatapp.service.MessageService;
import com.eszigeti.chatapp.service.NotificationService;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class MessageReceiverService {

    private final MessageService messageService;
    private final NotificationService  notificationService;

    public MessageReceiverService(MessageService messageService, NotificationService notificationService) {
        this.messageService = messageService;
        this.notificationService = notificationService;
    }

    @JmsListener(destination = ActiveMQConfig.QUEUE_NAME)
    public void onMessage(@Payload Message message) {
        Message updateMessage = messageService.updateMessage(message);
        notificationService.notifyReceiver(updateMessage);
    }
}
