package com.example.CollabDoc.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.CollabDoc.entities.Auth;

public interface UserRepository extends CrudRepository<Auth, Long> {
	Auth findByName(String name);
}
