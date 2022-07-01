package com.eszigeti.chatapp.service;

import com.eszigeti.chatapp.model.User;

public interface UserService {

    User saveUser(final User user);

    void deleteById(final long userId);

    User getUser(final long userId);
}
