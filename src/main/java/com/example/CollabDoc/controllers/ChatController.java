//package com.example.CollabDoc.controllers;
//
//import com.example.CollabDoc.entities.ChatMessage;
//import org.springframework.messaging.handler.annotation.MessageMapping;
//import org.springframework.messaging.handler.annotation.Payload;
//import org.springframework.messaging.handler.annotation.SendTo;
//import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.CrossOrigin;
//
//@Controller
//@CrossOrigin
//public class ChatController {
//
//    @MessageMapping("/chat.sendMessage")
//    @SendTo("/topic/public")
//    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
//        return chatMessage;
//    }
//
//    @MessageMapping("/chat.addUser")
//    @SendTo("/topic/public")
//    public ChatMessage addUser(@Payload ChatMessage chatMessage, 
//                               SimpMessageHeaderAccessor headerAccessor) {
//        // Add username in web socket session
//        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
//        return chatMessage;
//    }
//
//}

package com.example.CollabDoc.controllers;

import com.example.CollabDoc.entities.ChatMessage;
import com.example.CollabDoc.services.ChatMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//import java.time.LocalDateTime;
import java.util.List;

@Controller
@CrossOrigin
public class ChatController {

    @Autowired
    private ChatMessageService chatMessageService;

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
//        chatMessage.setTimestamp(LocalDateTime.now());
        return chatMessageService.saveMessage(chatMessage);
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public ChatMessage addUser(@Payload ChatMessage chatMessage, 
                               SimpMessageHeaderAccessor headerAccessor) {
        // Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
//        chatMessage.setTimestamp(LocalDateTime.now());
        return chatMessageService.saveMessage(chatMessage);
    }
    
    @GetMapping("/messages/{user1}/{user2}")
    @ResponseBody
    public List<ChatMessage> getMessagesBetweenUsers(@PathVariable String user1, @PathVariable String user2) {
        return chatMessageService.getMessagesBetweenUsers(user1, user2);
    }
    
}

@RestController
@CrossOrigin
class MessageRestController {

    @Autowired
    private ChatMessageService chatMessageService;

    @GetMapping("/api/messages")
    public List<ChatMessage> getMessages() {
        return chatMessageService.getAllMessages();
    }
}
