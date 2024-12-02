package com.sygebib.demo.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sygebib.demo.Models.Etagere;

@Repository
public interface EtagereRepos extends JpaRepository<Etagere, Long> {

}
