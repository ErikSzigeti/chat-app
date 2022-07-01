package com.eszigeti.chatapp.service.impl;

import com.eszigeti.chatapp.model.Message;
import com.eszigeti.chatapp.service.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceDummyImpl implements NotificationService {

    private static final Logger logger = LoggerFactory.getLogger(NotificationServiceDummyImpl.class);

    @Override
    public void notifyReceiver(Message message) {
        //on a production code this would trigger a notification to the receiver
        logger.info("Notifying user " + message.getReceiver().getId() + " about a new message.");
    }
}
