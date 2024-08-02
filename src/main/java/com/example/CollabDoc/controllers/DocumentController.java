package com.example.CollabDoc.controllers;

import com.example.CollabDoc.entities.*;
import com.example.CollabDoc.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/document")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @PostMapping
    public void saveDocument(@RequestBody String content) {
        documentService.saveDocument(content);
    }

    @GetMapping
    public Document getDocument() {
        return documentService.getLatestDocument();
    }
}
