package com.sentiment.dataretrieval.dummy;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Fail.fail;

public class DummyDataRetrievalServiceTest {

	private final DummyDataRetrievalService service = new DummyDataRetrievalService();

	@Test
	public void fetchData_ShouldReturnJsonString() {
		String jsonString = service.fetchData();
		ObjectMapper mapper = new ObjectMapper();

		assertThat(jsonString).isNotEmpty();
		System.out.println(jsonString);
		try {
			assertThat(mapper.readTree(jsonString)).isInstanceOf(JsonNode.class);
		} catch(Exception e) {
			fail("Exception thrown while parsing JSON");
		}
	}
}
