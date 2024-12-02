package com.sygebib.demo.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sygebib.demo.Models.Document;

@Repository
public interface DocumentRepos extends JpaRepository<Document, Long> {

}
