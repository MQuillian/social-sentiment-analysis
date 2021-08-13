package com.sentiment.searchengine;

import static org.assertj.core.api.Assertions.assertThat;

import com.sentiment.searchengine.elastic.ElasticService;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest()
public class ElasticServiceTest {

	@Autowired
	private ElasticService svc;

	@Test
	public void contextLoads() {
		assertThat(svc.processData("dummy")).isEqualTo("DUMMY");
	}

	@SpringBootApplication
	static class TestConfiguration {
	}
}
