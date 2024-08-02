package com.example.CollabDoc.repository;

import com.example.CollabDoc.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends CrudRepository<Document, Long> {
}
