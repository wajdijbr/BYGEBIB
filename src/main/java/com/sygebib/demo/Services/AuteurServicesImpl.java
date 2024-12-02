package com.sygebib.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.sygebib.demo.Models.Auteur;
import com.sygebib.demo.Repos.AuteurRepos;

@Service
public class AuteurServicesImpl implements AuteurServices {
   @Autowired
   private AuteurRepos auteurRepos;

   @Override
   public Auteur saveAuteur(Auteur auteur) {
      return auteurRepos.save(auteur);
   }

   @Override
   public Auteur updateAuteur(Auteur auteur) {
      return auteurRepos.save(auteur);
   }

   @Override
   public void deleteAuteur(Auteur auteur) {
      auteurRepos.delete(auteur);
   }

   @Override
   public void deleteAuteurById(Long idAuteur) {
      auteurRepos.deleteById(idAuteur);
   }

   @Override
   public Auteur getAuteur(Long idAuteur) throws NotFoundException {

      Auteur auteur = auteurRepos.findById(idAuteur).get();
      if (auteur == null)
         throw new NotFoundException();
      return auteur;
   }

   @Override
   public List<Auteur> getAllAuteurs() {
      return auteurRepos.findAll();
   }
}
