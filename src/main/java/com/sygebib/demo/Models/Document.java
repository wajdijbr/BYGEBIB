package com.sygebib.demo.Models;

import java.util.Date;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "documents")
@Inheritance(strategy = InheritanceType.JOINED)
public class Document {
   @Id
   @GeneratedValue
   private Long idDocument;
   private Long cote;

   private String titre;

   private String theme;
   private Date dateParution;

   // @Override
   // public String toString() {
   // return "Produit [idDoc=" + idDocument + ", Titre=" +
   // titre + ", Date de parution=" + dateParution
   // + ", Theme=" + theme + "]";
   // }

}
