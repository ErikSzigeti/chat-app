package com.eszigeti.chatapp.service;

import com.eszigeti.chatapp.model.Message;
import com.eszigeti.chatapp.model.MessageStatus;

import java.util.List;

public interface MessageService {

    Message saveMessage(final long senderId, final long receiverId, final Message message);

    List<Message> getMessages(final long firstUserId, final long secondUserId);

    Message updateMessage(final Message message);
}
