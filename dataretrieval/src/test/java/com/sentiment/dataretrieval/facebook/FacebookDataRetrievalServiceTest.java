package com.sentiment.dataretrieval.facebook;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest("service.message=Hello")
public class FacebookDataRetrievalServiceTest {

	@Autowired
	private FacebookDataRetrievalService myService;

	@Test
	public void contextLoads() {
		assertThat(myService.fetchData()).isEqualTo("lowercase data from fb");
	}

	@SpringBootApplication
	static class TestConfiguration {
	}

}
