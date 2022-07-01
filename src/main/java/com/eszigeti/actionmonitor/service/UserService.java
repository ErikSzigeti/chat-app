package com.eszigeti.actionmonitor.service;

import com.eszigeti.actionmonitor.model.User;

public interface UserService {

    User saveUser(final User user);

    void deleteById(final long userId);

    User getUser(final long userId);
}
