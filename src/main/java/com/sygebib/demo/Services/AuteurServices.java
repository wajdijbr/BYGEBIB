package com.sygebib.demo.Services;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.sygebib.demo.Models.Auteur;

public interface AuteurServices {

   Auteur saveAuteur(Auteur auteur);

   Auteur updateAuteur(Auteur auteur);

   void deleteAuteur(Auteur auteur);

   void deleteAuteurById(Long idAuteur);

   Auteur getAuteur(Long idAuteur) throws NotFoundException;

   List<Auteur> getAllAuteurs();

}
