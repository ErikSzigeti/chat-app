package com.eszigeti.chatapp.controller;

import com.eszigeti.chatapp.model.User;
import com.eszigeti.chatapp.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @DeleteMapping("/delete/{userId}")
    public void deleteUser(@PathVariable long userId) {
        userService.deleteById(userId);
    }

}
