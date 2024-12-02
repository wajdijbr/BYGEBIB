package com.sygebib.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.sygebib.demo.Models.Ouvrage;
import com.sygebib.demo.Repos.OuvrageRepos;

@Service
public class OuvrageServicesImpl implements OuvrageServices {
   @Autowired
   private OuvrageRepos ouvrageRepos;

   @Override
   public Ouvrage saveOuvrage(Ouvrage ouvrage) {
      return ouvrageRepos.save(ouvrage);
   }

   @Override
   public Ouvrage updateOuvrage(Ouvrage ouvrage) {
      return ouvrageRepos.save(ouvrage);
   }

   @Override
   public void deleteOuvrage(Ouvrage ouvrage) {
      ouvrageRepos.delete(ouvrage);
   }

   @Override
   public void deleteOuvrageById(Long idDocument) {
      ouvrageRepos.deleteById(idDocument);
   }

   @Override
   public Ouvrage getOuvrage(Long idDocument) throws NotFoundException {

      Ouvrage ouvrage = ouvrageRepos.findById(idDocument).get();
      if (ouvrage == null)
         throw new NotFoundException();
      return ouvrage;
   }

   @Override
   public List<Ouvrage> getAllOuvrages() {
      return ouvrageRepos.findAll();
   }
}
