package com.sentiment.webapp;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest("service.message=Hello")
public class DataServiceImplTest {

	@Autowired
	private DataServiceImpl service;

	@Test
	public void service_ReturnsMessage() {
		assertThat(service.message()).isNotNull();
	}

	@SpringBootApplication
	static class TestConfiguration {
	}

}
