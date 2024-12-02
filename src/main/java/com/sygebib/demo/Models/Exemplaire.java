package com.sygebib.demo.Models;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Exemplaires")
public class Exemplaire {
   @Id
   @GeneratedValue
   private Long idExemplaire;
   private List<String> status = Arrays.asList("DISPONIBLE", "PRETE", "EXCLU");
   private Date dateAcq;
   @ManyToOne
   @JoinColumn(name = "id_document", nullable = false) // Foreign key to Document
   private Document document;

}
