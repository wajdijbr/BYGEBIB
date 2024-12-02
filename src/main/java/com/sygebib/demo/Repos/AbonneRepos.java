package com.sygebib.demo.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sygebib.demo.Models.Abonne;

@Repository
public interface AbonneRepos extends JpaRepository<Abonne, Long> {

}
