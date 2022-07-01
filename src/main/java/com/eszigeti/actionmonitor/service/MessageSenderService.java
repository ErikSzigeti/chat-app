package com.eszigeti.actionmonitor.service;

import com.eszigeti.actionmonitor.model.Message;

public interface MessageSenderService {

    void sendMessage(final long senderId, final long receiverId, final Message message);
}
