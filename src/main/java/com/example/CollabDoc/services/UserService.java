package com.example.CollabDoc.services;

import com.example.CollabDoc.entities.Auth;
import com.example.CollabDoc.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Auth findByUsername(String username) {
        return userRepository.findByName(username);
    }

    public Auth save(Auth user) {
        return userRepository.save(user);
    }

    public List<Auth> findAll() {
        return (List<Auth>) userRepository.findAll();
    }
    
    public Auth getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
