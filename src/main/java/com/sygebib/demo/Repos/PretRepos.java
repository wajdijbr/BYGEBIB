package com.sygebib.demo.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sygebib.demo.Models.Pret;

@Repository
public interface PretRepos extends JpaRepository<Pret, Long> {

}