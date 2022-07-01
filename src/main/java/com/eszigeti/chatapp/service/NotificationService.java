package com.eszigeti.chatapp.service;

import com.eszigeti.chatapp.model.Message;

public interface NotificationService {
    void notifyReceiver(final Message message);
}
