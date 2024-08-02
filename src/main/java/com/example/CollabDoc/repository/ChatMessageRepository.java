package com.example.CollabDoc.repository;

import com.example.CollabDoc.entities.ChatMessage;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatMessageRepository extends CrudRepository<ChatMessage, Long> {
	List<ChatMessage> findAllBySenderAndRecipient(String sender, String recipient);
    List<ChatMessage> findAllBySenderOrRecipient(String sender, String recipient);
}
