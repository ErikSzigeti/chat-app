package com.eszigeti.chatapp.controller;

import com.eszigeti.chatapp.model.Message;
import com.eszigeti.chatapp.service.MessageSenderService;
import com.eszigeti.chatapp.service.MessageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessagesController {

    private final MessageService messageService;
    private final MessageSenderService messageSenderService;

    public MessagesController(MessageService messageService, MessageSenderService messageSenderService) {
        this.messageService = messageService;
        this.messageSenderService = messageSenderService;
    }

    @PostMapping("/{userId}/send")
    public void sendMessage(@PathVariable long userId, @RequestParam long receiverId, @RequestBody Message message) {
        messageSenderService.sendMessage(userId, receiverId, message);
    }

    @GetMapping("/{userId}")
    public List<Message> getAllMessagesBetweenUsers(@PathVariable long userId, @RequestParam long otherUserId) {
        return messageService.getMessages(userId, otherUserId);
    }
}
