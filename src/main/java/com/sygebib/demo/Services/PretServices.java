package com.sygebib.demo.Services;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.sygebib.demo.Models.Pret;

public interface PretServices {

   Pret savePret(Pret pret);

   Pret updatePret(Pret pret);

   void deletePret(Pret pret);

   void deletePretById(Long idPret);

   Pret getPret(Long idPret) throws NotFoundException;

   List<Pret> getAllPrets();

}
