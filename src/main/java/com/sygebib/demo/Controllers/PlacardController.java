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

import com.sygebib.demo.Models.Placard;
import com.sygebib.demo.Services.PlacardServices;

@RestController

@RequestMapping("/Placards")
@CrossOrigin("*")
public class PlacardController {
   @Autowired
   private PlacardServices placardServices;

   @RequestMapping(method = RequestMethod.GET)
   public List<Placard> getAllPlacards() {
      return placardServices.getAllPlacards();
   }

   @RequestMapping(value = "/{id}", method = RequestMethod.GET)
   public Placard getPlacard(@PathVariable("id") Long idPlacard) throws NotFoundException {
      return placardServices.getPlacard(idPlacard);
   }

   @RequestMapping(method = RequestMethod.POST)
   public Placard createPlacard(@RequestBody Placard placard) {
      return placardServices.savePlacard(placard);
   }

   @RequestMapping(method = RequestMethod.PUT)
   public Placard updatePlacard(@RequestBody Placard placard) {
      return placardServices.updatePlacard(placard);

   }

   @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
   public void deletePlacard(@PathVariable("id") Long idPlacard) {
      Placard placard = null;
      try {
         placard = placardServices.getPlacard(idPlacard);
      } catch (NotFoundException e) {
         throw new ResponseStatusException(
               HttpStatus.NOT_FOUND, "Get Placard");
      }
      placardServices.deletePlacard(placard);
   }

}
