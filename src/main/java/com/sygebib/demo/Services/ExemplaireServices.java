package com.sygebib.demo.Services;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.sygebib.demo.Models.Exemplaire;

public interface ExemplaireServices {

   Exemplaire saveExemplaire(Exemplaire exemplaire);

   Exemplaire updateExemplaire(Exemplaire exemplaire);

   void deleteExemplaire(Exemplaire exemplaire);

   void deleteExemplaireById(Long idExemplaire);

   Exemplaire getExemplaire(Long idExemplaire) throws NotFoundException;

   List<Exemplaire> getAllExemplaires();

}
