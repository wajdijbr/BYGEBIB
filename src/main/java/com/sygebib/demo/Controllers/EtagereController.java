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

import com.sygebib.demo.Models.Etagere;
import com.sygebib.demo.Services.EtagereServices;

@RestController

@RequestMapping("/Etageres")
@CrossOrigin("*")
public class EtagereController {
   @Autowired
   private EtagereServices etagereServices;

   @RequestMapping(method = RequestMethod.GET)
   public List<Etagere> getAllEtageres() {
      return etagereServices.getAllEtageres();
   }

   @RequestMapping(value = "/{id}", method = RequestMethod.GET)
   public Etagere getEtagere(@PathVariable("id") Long idEtagere) throws NotFoundException {
      return etagereServices.getEtagere(idEtagere);
   }

   @RequestMapping(method = RequestMethod.POST)
   public Etagere createEtagere(@RequestBody Etagere etagere) {
      return etagereServices.saveEtagere(etagere);
   }

   @RequestMapping(method = RequestMethod.PUT)
   public Etagere updateEtagere(@RequestBody Etagere etagere) {
      return etagereServices.updateEtagere(etagere);

   }

   @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
   public void deleteEtagere(@PathVariable("id") Long idEtagere) {
      Etagere etagere = null;
      try {
         etagere = etagereServices.getEtagere(idEtagere);
      } catch (NotFoundException e) {
         throw new ResponseStatusException(
               HttpStatus.NOT_FOUND, "Get Etagere");
      }
      etagereServices.deleteEtagere(etagere);
   }

}
