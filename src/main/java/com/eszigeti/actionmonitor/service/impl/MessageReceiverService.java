package com.eszigeti.actionmonitor.service.impl;

import com.eszigeti.actionmonitor.configuration.mq.ActiveMQConfig;
import com.eszigeti.actionmonitor.model.Message;
import com.eszigeti.actionmonitor.service.MessageService;
import com.eszigeti.actionmonitor.service.NotificationService;
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
