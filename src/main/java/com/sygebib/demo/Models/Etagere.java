package com.sygebib.demo.Models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "etageres")
public class Etagere {
   @Id
   @GeneratedValue
   private Long idEtagere;
   private Long numero;
   private String libelle;
   @ManyToOne
   @JoinColumn(name = "id_placard", nullable = false) // Foreign key to Document
   private Placard placard;

}
