package com.sygebib.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.sygebib.demo.Models.Exemplaire;
import com.sygebib.demo.Repos.ExemplaireRepos;

@Service
public class ExemplaireServicesImpl implements ExemplaireServices {
   @Autowired
   private ExemplaireRepos exemplaireRepos;

   @Override
   public Exemplaire saveExemplaire(Exemplaire exemplaire) {
      return exemplaireRepos.save(exemplaire);
   }

   @Override
   public Exemplaire updateExemplaire(Exemplaire exemplaire) {
      return exemplaireRepos.save(exemplaire);
   }

   @Override
   public void deleteExemplaire(Exemplaire exemplaire) {
      exemplaireRepos.delete(exemplaire);
   }

   @Override
   public void deleteExemplaireById(Long idExemplaire) {
      exemplaireRepos.deleteById(idExemplaire);
   }

   @Override
   public Exemplaire getExemplaire(Long idExemplaire) throws NotFoundException {

      Exemplaire exemplaire = exemplaireRepos.findById(idExemplaire).get();
      if (exemplaire == null)
         throw new NotFoundException();
      return exemplaire;
   }

   @Override
   public List<Exemplaire> getAllExemplaires() {
      return exemplaireRepos.findAll();
   }
}
