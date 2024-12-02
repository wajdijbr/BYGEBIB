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

import com.sygebib.demo.Models.Auteur;
import com.sygebib.demo.Services.AuteurServices;

@RestController

@RequestMapping("/auteurs")
@CrossOrigin("*")
public class AuteurController {
   @Autowired
   private AuteurServices auteurServices;

   @RequestMapping(method = RequestMethod.GET)
   public List<Auteur> getAllAuteurs() {
      return auteurServices.getAllAuteurs();
   }

   @RequestMapping(value = "/{id}", method = RequestMethod.GET)
   public Auteur getAuteur(@PathVariable("id") Long idAuteur) throws NotFoundException {
      return auteurServices.getAuteur(idAuteur);
   }

   @RequestMapping(method = RequestMethod.POST)
   public Auteur createAuteur(@RequestBody Auteur auteur) {
      return auteurServices.saveAuteur(auteur);
   }

   @RequestMapping(method = RequestMethod.PUT)
   public Auteur updateAuteur(@RequestBody Auteur auteur) {
      return auteurServices.updateAuteur(auteur);

   }

   @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
   public void deleteAuteur(@PathVariable("id") Long idAuteur) {
      Auteur auteur = null;
      try {
         auteur = auteurServices.getAuteur(idAuteur);
      } catch (NotFoundException e) {
         throw new ResponseStatusException(
               HttpStatus.NOT_FOUND, "Get Auteur");
      }
      auteurServices.deleteAuteur(auteur);
   }

}
