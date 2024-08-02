package com.example.CollabDoc.services;

import com.example.CollabDoc.entities.ChatMessage;
import com.example.CollabDoc.repository.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatMessageService {

    @Autowired
    private ChatMessageRepository chatMessageRepository;

    public ChatMessage saveMessage(ChatMessage message) {
        return chatMessageRepository.save(message);
    }

    public List<ChatMessage> getAllMessages() {
        return (List<ChatMessage>) chatMessageRepository.findAll();
    }
    
    public List<ChatMessage> getMessagesBetweenUsers(String user1, String user2) {

        return chatMessageRepository.findAllBySenderAndRecipient(user1, user2);
    }
}
