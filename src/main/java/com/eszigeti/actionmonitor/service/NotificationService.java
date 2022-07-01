package com.eszigeti.actionmonitor.service;

import com.eszigeti.actionmonitor.model.Message;

public interface NotificationService {
    void notifyReceiver(final Message message);
}
