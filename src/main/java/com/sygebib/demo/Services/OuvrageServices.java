package com.sygebib.demo.Services;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.sygebib.demo.Models.Ouvrage;

public interface OuvrageServices {

   Ouvrage saveOuvrage(Ouvrage ouvrage);

   Ouvrage updateOuvrage(Ouvrage ouvrage);

   void deleteOuvrage(Ouvrage ouvrage);

   void deleteOuvrageById(Long idDocument);

   Ouvrage getOuvrage(Long idDocument) throws NotFoundException;

   List<Ouvrage> getAllOuvrages();

}
