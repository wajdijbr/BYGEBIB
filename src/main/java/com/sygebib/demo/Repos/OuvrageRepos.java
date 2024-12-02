package com.sygebib.demo.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sygebib.demo.Models.Ouvrage;

@Repository
public interface OuvrageRepos extends JpaRepository<Ouvrage, Long> {

}
