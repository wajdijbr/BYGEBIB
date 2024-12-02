package com.sygebib.demo.Models;

import java.util.Arrays;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "Memoires")

public class Memoire extends Document {

   @Column(nullable = false)
   private List<String> type = Arrays.asList("LICENCE", "MASTER", "DOCTORAT");

}
