package com.sentiment.dataprocessing.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest()
public class ElasticSearchRepositoryTest {

	@Autowired
	private ElasticSearchRepository repo;

	@Test
	public void contextLoads() {
		assertThat(repo.processData("dummy")).isEqualTo("DUMMY");
	}

	@SpringBootApplication
	static class TestConfiguration {
	}
}
