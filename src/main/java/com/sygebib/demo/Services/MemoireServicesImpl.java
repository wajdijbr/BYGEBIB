package com.sygebib.demo.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.sygebib.demo.Models.Memoire;
import com.sygebib.demo.Repos.MemoireRepos;

@Service
public class MemoireServicesImpl implements MemoireServices {
   @Autowired
   private MemoireRepos memoireRepos;

   @Override
   public Memoire saveMemoire(Memoire memoire) {
      return memoireRepos.save(memoire);
   }

   @Override
   public Memoire updateMemoire(Memoire memoire) {
      return memoireRepos.save(memoire);
   }

   @Override
   public void deleteMemoire(Memoire memoire) {
      memoireRepos.delete(memoire);
   }

   @Override
   public void deleteMemoireById(Long idDocument) {
      memoireRepos.deleteById(idDocument);
   }

   @Override
   public Memoire getMemoire(Long idDocument) throws NotFoundException {

      Memoire memoire = memoireRepos.findById(idDocument).get();
      if (memoire == null)
         throw new NotFoundException();
      return memoire;
   }

   @Override
   public List<Memoire> getAllMemoires() {
      return memoireRepos.findAll();
   }
}
