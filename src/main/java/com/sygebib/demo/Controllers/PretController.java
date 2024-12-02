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

import com.sygebib.demo.Models.Pret;
import com.sygebib.demo.Services.PretServices;

@RestController

@RequestMapping("/prets")
@CrossOrigin("*")
public class PretController {
   @Autowired
   private PretServices pretServices;

   @RequestMapping(method = RequestMethod.GET)
   public List<Pret> getAllPrets() {
      return pretServices.getAllPrets();
   }

   @RequestMapping(value = "/{id}", method = RequestMethod.GET)
   public Pret getPret(@PathVariable("id") Long idPret) throws NotFoundException {
      return pretServices.getPret(idPret);
   }

   @RequestMapping(method = RequestMethod.POST)
   public Pret createPret(@RequestBody Pret pret) {
      return pretServices.savePret(pret);
   }

   @RequestMapping(method = RequestMethod.PUT)
   public Pret updatePret(@RequestBody Pret pret) {
      return pretServices.updatePret(pret);

   }

   @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
   public void deletePret(@PathVariable("id") Long idPret) {
      Pret pret = null;
      try {
         pret = pretServices.getPret(idPret);
      } catch (NotFoundException e) {
         throw new ResponseStatusException(
               HttpStatus.NOT_FOUND, "Get Pret");
      }
      pretServices.deletePret(pret);
   }

}
