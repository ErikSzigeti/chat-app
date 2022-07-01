package com.eszigeti.actionmonitor.controller;

import com.eszigeti.actionmonitor.model.User;
import com.eszigeti.actionmonitor.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public User saveUser(@RequestBody User user) {
        logger.debug("Incoming request to Path : /user/save  Request: " + user);
        return userService.saveUser(user);
    }

    @DeleteMapping("/delete/{userId}")
    public void deleteUser(@PathVariable long userId) {
        logger.debug("Incoming request to Path: /delete/" + userId);
        userService.deleteById(userId);
    }

}
