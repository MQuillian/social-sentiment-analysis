package com.sentiment.searchengine.elastic;

import com.fasterxml.jackson.core.JsonParseException;
import com.sentiment.analysis.NaturalLanguageProcessor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ElasticServiceTest {

	@Mock
	private SentimentElasticRepository repository;
	@Mock
	private NaturalLanguageProcessor nlp;

	@InjectMocks
	private ElasticService service;

	@Test
	public void processData_GivenValidJsonString_ShouldSaveProcessedData() {

		ArgumentCaptor<ArrayList<SentimentDocument>> captor = ArgumentCaptor.forClass(ArrayList.class);
		String validJsonString = "{\"0\": {\"fullText\": \"This is valid Json\"}}";

		when(nlp.analyzeSentiment(any(String.class))).thenReturn(2);

		service.processData(validJsonString);

		verify(repository).saveAll((captor.capture()));
		assertThat(captor.getValue().get(0)).isInstanceOf(SentimentDocument.class);
		assertThat(captor.getValue().get(0)).hasFieldOrPropertyWithValue("content", "This is valid Json");
		assertThat(captor.getValue().get(0)).hasFieldOrPropertyWithValue("sentiment", 2);
	}

	@Test
	public void processData_GivenInvalidJsonString_ShouldNotAnalyzeOrSave() {
		String invalidJsonString = "Not a Json string";
		service.processData(invalidJsonString);
		verifyNoInteractions(nlp);
		verifyNoInteractions(repository);
	}
}