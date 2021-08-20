package com.sentiment.webapp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.sentiment.dataretrieval.dummy.DummyDataRetrievalService;
import com.sentiment.searchengine.elastic.ElasticService;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

@ExtendWith(MockitoExtension.class)
public class DataServiceImplTest {

	@Mock
	private DummyDataRetrievalService retrievalService;
	@Mock
	private ElasticService searchService;

	@InjectMocks
	private DataServiceImpl service;

	@Test
	public void service_ReturnsMessage() {
		when(retrievalService.fetchData()).thenReturn("Unprocessed data");
		when(searchService.processData("Unprocessed data")).thenReturn("PROCESSED DATA");
		assertThat(service.message()).isEqualTo("PROCESSED DATA");
	}
}
