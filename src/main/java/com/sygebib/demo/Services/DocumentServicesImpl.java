package com.sygebib.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.sygebib.demo.Models.Document;
import com.sygebib.demo.Repos.DocumentRepos;

@Service
public class DocumentServicesImpl implements DocumentServices {
   @Autowired
   private DocumentRepos documentRepos;

   @Override
   public Document saveDocument(Document document) {
      return documentRepos.save(document);
   }

   @Override
   public Document updateDocument(Document document) {
      return documentRepos.save(document);
   }

   @Override
   public void deleteDocument(Document document) {
      documentRepos.delete(document);
   }

   @Override
   public void deleteDocumentById(Long idDocument) {
      documentRepos.deleteById(idDocument);
   }

   @Override
   public Document getDocument(Long idDocument) throws NotFoundException {

      Document document = documentRepos.findById(idDocument).get();
      if (document == null)
         throw new NotFoundException();
      return document;
   }

   @Override
   public List<Document> getAllDocuments() {
      return documentRepos.findAll();
   }
}
