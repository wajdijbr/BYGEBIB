package com.sygebib.demo.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sygebib.demo.Models.Memoire;

@Repository
public interface MemoireRepos extends JpaRepository<Memoire, Long> {

}
