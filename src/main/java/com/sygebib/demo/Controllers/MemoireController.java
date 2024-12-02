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

import com.sygebib.demo.Models.Memoire;
import com.sygebib.demo.Services.MemoireServices;

@RestController

@RequestMapping("/Memoires")
@CrossOrigin("*")
public class MemoireController {
   @Autowired
   private MemoireServices memoireServices;

   @RequestMapping(method = RequestMethod.GET)
   public List<Memoire> getAllMemoires() {
      return memoireServices.getAllMemoires();
   }

   @RequestMapping(value = "/{id}", method = RequestMethod.GET)
   public Memoire getMemoire(@PathVariable("id") Long idDocument) throws NotFoundException {
      return memoireServices.getMemoire(idDocument);
   }

   @RequestMapping(method = RequestMethod.POST)
   public Memoire createMemoire(@RequestBody Memoire memoire) {
      return memoireServices.saveMemoire(memoire);
   }

   @RequestMapping(method = RequestMethod.PUT)
   public Memoire updateMemoire(@RequestBody Memoire memoire) {
      return memoireServices.updateMemoire(memoire);

   }

   @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
   public void deleteMemoire(@PathVariable("id") Long idDocument) {
      Memoire memoire = null;
      try {
         memoire = memoireServices.getMemoire(idDocument);
      } catch (NotFoundException e) {
         throw new ResponseStatusException(
               HttpStatus.NOT_FOUND, "Get Memoire");
      }
      memoireServices.deleteMemoire(memoire);
   }

}
