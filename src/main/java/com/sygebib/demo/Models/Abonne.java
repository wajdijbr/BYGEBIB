package com.sygebib.demo.Models;

import java.util.Date;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Abonnes")
public class Abonne {
   @Id
   @GeneratedValue
   private Long idAbonne;
   private Long cin;
   private String nom;
   private String prenom;
   private Long telephone;
   private Date dateAbonnement;

}
