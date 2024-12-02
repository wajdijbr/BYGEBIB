package com.sygebib.demo.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.sygebib.demo.Models.Document;
import com.sygebib.demo.Services.DocumentServices;

@RestController

@RequestMapping("/documents")
@CrossOrigin("*")
public class DocumentController {
   @Autowired
   private DocumentServices documentServices;

   @RequestMapping(method = RequestMethod.GET)
   public List<Document> getAllDocuments() {
      return documentServices.getAllDocuments();
   }

   @RequestMapping(value = "/{id}", method = RequestMethod.GET)
   public Document getDocument(@PathVariable("id") Long idDocument) throws NotFoundException {
      return documentServices.getDocument(idDocument);
   }

   @RequestMapping(method = RequestMethod.POST)
   public Document createDocument(@RequestBody Document document) {
      return documentServices.saveDocument(document);
   }

   @RequestMapping(method = RequestMethod.PUT)
   public Document updateDocument(@RequestBody Document document) {
      return documentServices.updateDocument(document);

   }

   @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
   public void deleteDocument(@PathVariable("id") Long idDocument) {
      Document document = null;
      try {
         document = documentServices.getDocument(idDocument);
      } catch (NotFoundException e) {
         throw new ResponseStatusException(
               HttpStatus.NOT_FOUND, "Get Document");
      }
      documentServices.deleteDocument(document);
   }

}
