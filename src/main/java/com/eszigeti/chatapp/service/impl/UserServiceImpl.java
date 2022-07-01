package com.eszigeti.chatapp.service.impl;

import com.eszigeti.chatapp.model.User;
import com.eszigeti.chatapp.repository.UserRepository;
import com.eszigeti.chatapp.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(final User user) {
        logger.debug("Saving new user");
        return userRepository.save(user);
    }

    @Override
    public void deleteById(final long userId) {
        logger.debug("Deleting user");
        userRepository.deleteById(userId);
    }

    @Override
    public User getUser(final long userId) {
        logger.debug("Getting user");
        return userRepository.findById(userId).orElseThrow();
    }
}
