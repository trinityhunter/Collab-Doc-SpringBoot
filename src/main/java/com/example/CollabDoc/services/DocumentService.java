package com.example.CollabDoc.services;

import com.example.CollabDoc.entities.*;

import com.example.CollabDoc.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    public Document saveDocument(String content) {
        Document document = new Document();
        String decodedString = URLDecoder.decode(content, StandardCharsets.UTF_8);
        String trimmed = decodedString.substring(0, decodedString.length()-1);
        document.setContent(trimmed);
        return documentRepository.save(document);
    }

    public Document getLatestDocument() {
    	long count = documentRepository.count();
        return documentRepository.findById(count).orElse(null);
    }
}
