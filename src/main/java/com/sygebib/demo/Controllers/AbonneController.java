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

import com.sygebib.demo.Models.Abonne;
import com.sygebib.demo.Services.AbonneServices;

@RestController

@RequestMapping("/abonnes")
@CrossOrigin("*")
public class AbonneController {
   @Autowired
   private AbonneServices abonneServices;

   @RequestMapping(method = RequestMethod.GET)
   public List<Abonne> getAllAbonnes() {
      return abonneServices.getAllAbonnes();
   }

   @RequestMapping(value = "/{id}", method = RequestMethod.GET)
   public Abonne getAbonne(@PathVariable("id") Long idAbonne) throws NotFoundException {
      return abonneServices.getAbonne(idAbonne);
   }

   @RequestMapping(method = RequestMethod.POST)
   public Abonne createAbonne(@RequestBody Abonne abonne) {
      return abonneServices.saveAbonne(abonne);
   }

   @RequestMapping(method = RequestMethod.PUT)
   public Abonne updateAbonne(@RequestBody Abonne abonne) {
      return abonneServices.updateAbonne(abonne);

   }

   @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
   public void deleteAbonne(@PathVariable("id") Long idAbonne) {
      Abonne abonne = null;
      try {
         abonne = abonneServices.getAbonne(idAbonne);
      } catch (NotFoundException e) {
         throw new ResponseStatusException(
               HttpStatus.NOT_FOUND, "Get Abonne");
      }
      abonneServices.deleteAbonne(abonne);
   }

}
