package com.sygebib.demo.Services;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.sygebib.demo.Models.Document;

public interface DocumentServices {

   Document saveDocument(Document document);

   Document updateDocument(Document document);

   void deleteDocument(Document document);

   void deleteDocumentById(Long idDocument);

   Document getDocument(Long idDocument) throws NotFoundException;

   List<Document> getAllDocuments();

}
