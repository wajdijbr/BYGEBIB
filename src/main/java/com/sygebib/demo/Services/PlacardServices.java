package com.sygebib.demo.Services;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.sygebib.demo.Models.Placard;

public interface PlacardServices {

   Placard savePlacard(Placard placard);

   Placard updatePlacard(Placard placard);

   void deletePlacard(Placard placard);

   void deletePlacardById(Long idPlacard);

   Placard getPlacard(Long idPlacard) throws NotFoundException;

   List<Placard> getAllPlacards();

}
