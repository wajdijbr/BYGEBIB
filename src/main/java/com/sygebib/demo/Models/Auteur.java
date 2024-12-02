package com.sygebib.demo.Models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "auteurs")
public class Auteur {
   @Id
   @GeneratedValue
   private Long idAuteur;
   private String nom;
   private String prenom;
   @ManyToMany
   @JoinTable(name = "document_auteur", joinColumns = @JoinColumn(name = "id_document"), inverseJoinColumns = @JoinColumn(name = "id_auteur"))
   private Set<Document> document = new HashSet<>();

}
