package com.sygebib.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.sygebib.demo.Models.Abonne;
import com.sygebib.demo.Repos.AbonneRepos;

@Service
public class AbonneServicesImpl implements AbonneServices {
   @Autowired
   private AbonneRepos abonneRepos;

   @Override
   public Abonne saveAbonne(Abonne abonne) {
      return abonneRepos.save(abonne);
   }

   @Override
   public Abonne updateAbonne(Abonne abonne) {
      return abonneRepos.save(abonne);
   }

   @Override
   public void deleteAbonne(Abonne abonne) {
      abonneRepos.delete(abonne);
   }

   @Override
   public void deleteAbonneById(Long idAbonne) {
      abonneRepos.deleteById(idAbonne);
   }

   @Override
   public Abonne getAbonne(Long idAbonne) throws NotFoundException {

      Abonne abonne = abonneRepos.findById(idAbonne).get();
      if (abonne == null)
         throw new NotFoundException();
      return abonne;
   }

   @Override
   public List<Abonne> getAllAbonnes() {
      return abonneRepos.findAll();
   }
}
