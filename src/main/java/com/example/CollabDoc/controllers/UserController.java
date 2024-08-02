package com.example.CollabDoc.controllers;

import com.example.CollabDoc.entities.*;
import com.example.CollabDoc.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<Auth> getAllUsers() {
        return userService.findAll();
    }

    @PostMapping
    public Auth createUser(@RequestBody Auth user) {
        return userService.save(user);
    }
}
