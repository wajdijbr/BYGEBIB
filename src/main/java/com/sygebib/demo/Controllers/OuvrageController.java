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

import com.sygebib.demo.Models.Ouvrage;
import com.sygebib.demo.Services.OuvrageServices;

@RestController

@RequestMapping("/Ouvrages")
@CrossOrigin("*")
public class OuvrageController {
   @Autowired
   private OuvrageServices ouvrageServices;

   @RequestMapping(method = RequestMethod.GET)
   public List<Ouvrage> getAllOuvrages() {
      return ouvrageServices.getAllOuvrages();
   }

   @RequestMapping(value = "/{id}", method = RequestMethod.GET)
   public Ouvrage getOuvrage(@PathVariable("id") Long idDocument) throws NotFoundException {
      return ouvrageServices.getOuvrage(idDocument);
   }

   @RequestMapping(method = RequestMethod.POST)
   public Ouvrage createOuvrage(@RequestBody Ouvrage ouvrage) {
      return ouvrageServices.saveOuvrage(ouvrage);
   }

   @RequestMapping(method = RequestMethod.PUT)
   public Ouvrage updateOuvrage(@RequestBody Ouvrage ouvrage) {
      return ouvrageServices.updateOuvrage(ouvrage);

   }

   @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
   public void deleteOuvrage(@PathVariable("id") Long idDocument) {
      Ouvrage Ouvrage = null;
      try {
         Ouvrage = ouvrageServices.getOuvrage(idDocument);
      } catch (NotFoundException e) {
         throw new ResponseStatusException(
               HttpStatus.NOT_FOUND, "Get Ouvrage");
      }
      ouvrageServices.deleteOuvrage(Ouvrage);
   }

}
