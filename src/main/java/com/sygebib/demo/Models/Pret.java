package com.sygebib.demo.Models;

import java.util.Date;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Prets")
public class Pret {
   @Id
   @GeneratedValue
   private Long idPret;
   private Date datePret;
   private Date dateRetour;

   @ManyToOne
   @JoinColumn(name = "id_abonne", nullable = false)
   private Abonne abonne;

   @ManyToOne
   @JoinColumn(name = "id_exemplaire", nullable = false)
   private Exemplaire exemplaire;

}
