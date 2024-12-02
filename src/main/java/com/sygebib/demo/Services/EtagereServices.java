package com.sygebib.demo.Services;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.sygebib.demo.Models.Etagere;

public interface EtagereServices {

   Etagere saveEtagere(Etagere etagere);

   Etagere updateEtagere(Etagere etagere);

   void deleteEtagere(Etagere etagere);

   void deleteEtagereById(Long idEtagere);

   Etagere getEtagere(Long idEtagere) throws NotFoundException;

   List<Etagere> getAllEtageres();

}
