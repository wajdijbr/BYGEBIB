package com.sygebib.demo.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sygebib.demo.Models.Exemplaire;

@Repository
public interface ExemplaireRepos extends JpaRepository<Exemplaire, Long> {

}
