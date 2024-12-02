package com.sygebib.demo.Services;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.sygebib.demo.Models.Abonne;

public interface AbonneServices {

   Abonne saveAbonne(Abonne abonne);

   Abonne updateAbonne(Abonne abonne);

   void deleteAbonne(Abonne abonne);

   void deleteAbonneById(Long idAbonne);

   Abonne getAbonne(Long idAbonne) throws NotFoundException;

   List<Abonne> getAllAbonnes();

}
