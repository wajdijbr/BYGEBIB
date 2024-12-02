package com.sygebib.demo.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sygebib.demo.Models.Placard;

@Repository
public interface PlacardRepos extends JpaRepository<Placard, Long> {

}
