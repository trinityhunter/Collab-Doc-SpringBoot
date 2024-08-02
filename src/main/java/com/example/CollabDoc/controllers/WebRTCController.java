package com.example.CollabDoc.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

import com.example.CollabDoc.entities.CallMessage;
import com.example.CollabDoc.entities.Message;
import com.example.CollabDoc.entities.NegoMessage;
import com.example.CollabDoc.entities.Notification;

import java.util.HashMap;
import java.util.Map;

@RestController
public class WebRTCController {

    private final SimpMessagingTemplate messagingTemplate;
    private final Map<String, String> emailToSocketIdMap = new HashMap<>();
    private final Map<String, String> socketIdToEmailMap = new HashMap<>();

    public WebRTCController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/room/join")
    public void joinRoom(Message message) {
        String email = message.getEmail();
        String room = message.getRoom();
        String socketId = message.getSocketId();

        emailToSocketIdMap.put(email, socketId);
        socketIdToEmailMap.put(socketId, email);

        messagingTemplate.convertAndSend("/topic/" + room, new Notification(email, socketId, "user:joined"));
        messagingTemplate.convertAndSendToUser(socketId, "/queue/reply", message);
    }

    @MessageMapping("/user/call")
    public void callUser(CallMessage callMessage) {
        messagingTemplate.convertAndSendToUser(callMessage.getTo(), "/queue/call", callMessage);
    }

    @MessageMapping("/call/accepted")
    public void acceptCall(CallMessage callMessage) {
        messagingTemplate.convertAndSendToUser(callMessage.getTo(), "/queue/accepted", callMessage);
    }

    @MessageMapping("/peer/nego/needed")
    public void negotiatePeer(NegoMessage negoMessage) {
        messagingTemplate.convertAndSendToUser(negoMessage.getTo(), "/queue/nego", negoMessage);
    }

    @MessageMapping("/peer/nego/done")
    public void completeNegotiation(NegoMessage negoMessage) {
        messagingTemplate.convertAndSendToUser(negoMessage.getTo(), "/queue/nego/done", negoMessage);
    }
}
