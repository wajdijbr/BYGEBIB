package com.sygebib.demo.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sygebib.demo.Models.Auteur;

@Repository
public interface AuteurRepos extends JpaRepository<Auteur, Long> {

}
