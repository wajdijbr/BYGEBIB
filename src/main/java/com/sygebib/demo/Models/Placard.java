package com.sygebib.demo.Models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Placards")
public class Placard {
   @Id
   @GeneratedValue
   private Long idPlacard;
   private Long numero;
   private String libelle;

}
