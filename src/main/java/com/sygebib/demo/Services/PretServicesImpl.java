package com.sygebib.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.sygebib.demo.Models.Pret;
import com.sygebib.demo.Repos.PretRepos;

@Service
public class PretServicesImpl implements PretServices {
   @Autowired
   private PretRepos pretRepos;

   @Override
   public Pret savePret(Pret pret) {
      return pretRepos.save(pret);
   }

   @Override
   public Pret updatePret(Pret pret) {
      return pretRepos.save(pret);
   }

   @Override
   public void deletePret(Pret pret) {
      pretRepos.delete(pret);
   }

   @Override
   public void deletePretById(Long idPret) {
      pretRepos.deleteById(idPret);
   }

   @Override
   public Pret getPret(Long idPret) throws NotFoundException {

      Pret pret = pretRepos.findById(idPret).get();
      if (pret == null)
         throw new NotFoundException();
      return pret;
   }

   @Override
   public List<Pret> getAllPrets() {
      return pretRepos.findAll();
   }
}
