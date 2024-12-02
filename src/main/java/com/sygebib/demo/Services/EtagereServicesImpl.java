package com.sygebib.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.sygebib.demo.Models.Etagere;
import com.sygebib.demo.Repos.EtagereRepos;

@Service
public class EtagereServicesImpl implements EtagereServices {
   @Autowired
   private EtagereRepos etagereRepos;

   @Override
   public Etagere saveEtagere(Etagere etagere) {
      return etagereRepos.save(etagere);
   }

   @Override
   public Etagere updateEtagere(Etagere etagere) {
      return etagereRepos.save(etagere);
   }

   @Override
   public void deleteEtagere(Etagere etagere) {
      etagereRepos.delete(etagere);
   }

   @Override
   public void deleteEtagereById(Long idEtagere) {
      etagereRepos.deleteById(idEtagere);
   }

   @Override
   public Etagere getEtagere(Long idEtagere) throws NotFoundException {

      Etagere etagere = etagereRepos.findById(idEtagere).get();
      if (etagere == null)
         throw new NotFoundException();
      return etagere;
   }

   @Override
   public List<Etagere> getAllEtageres() {
      return etagereRepos.findAll();
   }
}
