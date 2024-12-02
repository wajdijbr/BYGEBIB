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

import com.sygebib.demo.Models.Exemplaire;
import com.sygebib.demo.Services.ExemplaireServices;

@RestController

@RequestMapping("/exemplaires")
@CrossOrigin("*")
public class ExemplaireController {
   @Autowired
   private ExemplaireServices exemplaireServices;

   @RequestMapping(method = RequestMethod.GET)
   public List<Exemplaire> getAllExemplaires() {
      return exemplaireServices.getAllExemplaires();
   }

   @RequestMapping(value = "/{id}", method = RequestMethod.GET)
   public Exemplaire getExemplaire(@PathVariable("id") Long idExemplaire) throws NotFoundException {
      return exemplaireServices.getExemplaire(idExemplaire);
   }

   @RequestMapping(method = RequestMethod.POST)
   public Exemplaire createExemplaire(@RequestBody Exemplaire exemplaire) {
      return exemplaireServices.saveExemplaire(exemplaire);
   }

   @RequestMapping(method = RequestMethod.PUT)
   public Exemplaire updateExemplaire(@RequestBody Exemplaire exemplaire) {
      return exemplaireServices.updateExemplaire(exemplaire);

   }

   @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
   public void deleteExemplaire(@PathVariable("id") Long idExemplaire) {
      Exemplaire exemplaire = null;
      try {
         exemplaire = exemplaireServices.getExemplaire(idExemplaire);
      } catch (NotFoundException e) {
         throw new ResponseStatusException(
               HttpStatus.NOT_FOUND, "Get Exemplaire");
      }
      exemplaireServices.deleteExemplaire(exemplaire);
   }

}
