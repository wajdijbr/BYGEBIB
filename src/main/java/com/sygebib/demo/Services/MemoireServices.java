package com.sygebib.demo.Services;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.sygebib.demo.Models.Memoire;

public interface MemoireServices {

   Memoire saveMemoire(Memoire memoire);

   Memoire updateMemoire(Memoire memoire);

   void deleteMemoire(Memoire memoire);

   void deleteMemoireById(Long idDocument);

   Memoire getMemoire(Long idDocument) throws NotFoundException;

   List<Memoire> getAllMemoires();

}
