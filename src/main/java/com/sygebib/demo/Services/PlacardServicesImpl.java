package com.sygebib.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.sygebib.demo.Models.Placard;
import com.sygebib.demo.Repos.PlacardRepos;

@Service
public class PlacardServicesImpl implements PlacardServices {
   @Autowired
   private PlacardRepos placardRepos;

   @Override
   public Placard savePlacard(Placard Placard) {
      return placardRepos.save(Placard);
   }

   @Override
   public Placard updatePlacard(Placard placard) {
      return placardRepos.save(placard);
   }

   @Override
   public void deletePlacard(Placard placard) {
      placardRepos.delete(placard);
   }

   @Override
   public void deletePlacardById(Long idPlacard) {
      placardRepos.deleteById(idPlacard);
   }

   @Override
   public Placard getPlacard(Long idPlacard) throws NotFoundException {

      Placard placard = placardRepos.findById(idPlacard).get();
      if (placard == null)
         throw new NotFoundException();
      return placard;
   }

   @Override
   public List<Placard> getAllPlacards() {
      return placardRepos.findAll();
   }
}
