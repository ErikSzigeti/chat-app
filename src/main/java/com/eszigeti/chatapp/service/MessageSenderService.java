package com.eszigeti.chatapp.service;

import com.eszigeti.chatapp.model.Message;

public interface MessageSenderService {

    void sendMessage(final long senderId, final long receiverId, final Message message);
}
