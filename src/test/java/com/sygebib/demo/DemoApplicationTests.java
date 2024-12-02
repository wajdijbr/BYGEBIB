package com.sygebib.demo;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sygebib.demo.Models.Document;
import com.sygebib.demo.Repos.DocumentRepos;

@SpringBootTest
class DemoApplicationTests {
	@Autowired
	private DocumentRepos documentRepos;

	@Test
	void contextLoads() {
		Document document = new Document();
		documentRepos.save(document);
	}

	@Test
	void testFindDocument() {
		Document document = documentRepos.findById(1L).get();
		System.out.print(document);
	}

}
