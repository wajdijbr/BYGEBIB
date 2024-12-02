package com.sygebib.demo.Models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@Data
@Table(name = "ouvrages")
public class Ouvrage extends Document {
   private long isbn;
   private String editeur;

}
