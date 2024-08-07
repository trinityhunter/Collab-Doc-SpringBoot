package com.example.CollabDoc.controllers;

import com.example.CollabDoc.payload.LoginRequest;
import com.example.CollabDoc.payload.LoginResponse;
import com.example.CollabDoc.payload.SignupRequest;
import com.example.CollabDoc.services.AuthServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthServices authService;

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@jakarta.validation.Valid @RequestBody SignupRequest signUpRequest) {
        try {
            LoginResponse response = authService.signup(signUpRequest.getName(), signUpRequest.getEmail(), signUpRequest.getPassword());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@jakarta.validation.Valid @RequestBody LoginRequest loginRequest) {
        try {
            LoginResponse response = authService.login(loginRequest.getEmail(), loginRequest.getPassword());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }
}
