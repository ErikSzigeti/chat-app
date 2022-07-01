package com.eszigeti.chatapp.controller;

import com.eszigeti.chatapp.model.Message;
import com.eszigeti.chatapp.service.MessageSenderService;
import com.eszigeti.chatapp.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessagesController {

    private static final Logger logger = LoggerFactory.getLogger(MessagesController.class);

    private final MessageService messageService;
    private final MessageSenderService messageSenderService;

    public MessagesController(MessageService messageService, MessageSenderService messageSenderService) {
        this.messageService = messageService;
        this.messageSenderService = messageSenderService;
    }

    @PostMapping("/{userId}/send")
    public void sendMessage(@PathVariable long userId, @RequestParam long receiverId, @RequestBody Message message) {
        logger.debug("Incoming request to Path /messages/" + userId + "/send Params:  " + receiverId + "  Request: " + message);
        messageSenderService.sendMessage(userId, receiverId, message);
    }

    @GetMapping("/{userId}")
    public List<Message> getAllMessagesBetweenUsers(@PathVariable long userId, @RequestParam long otherUserId) {
        logger.debug("Incoming request to Path /messages/" + userId + "  Params: " + otherUserId);
        return messageService.getMessages(userId, otherUserId);
    }
}
