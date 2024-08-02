package com.example.CollabDoc.repository;

import com.example.CollabDoc.entities.Auth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AuthRepository extends CrudRepository<Auth, String> {
    Optional<Auth> findByEmail(String email);
}