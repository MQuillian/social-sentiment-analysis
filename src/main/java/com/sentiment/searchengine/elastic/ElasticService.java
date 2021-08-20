package com.sentiment.searchengine.elastic;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sentiment.analysis.NaturalLanguageProcessor;
import com.sentiment.searchengine.common.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service(value="elastic")
public class ElasticService implements SearchService {

	private SentimentElasticRepository repository;
	private NaturalLanguageProcessor nlp;

	@Autowired
	public ElasticService(SentimentElasticRepository repository, NaturalLanguageProcessor nlp) {
		this.repository = repository;
		this.nlp = nlp;
	}

	public String processData(String unprocessedData) throws Exception {
		ObjectMapper mapper = new ObjectMapper();
		JsonNode inputJson = mapper.readTree(unprocessedData);
		List<SentimentDocument> docs = createSentimentDocuments(inputJson);
		repository.saveAll(docs);

		return unprocessedData;
	}

	private List<SentimentDocument> createSentimentDocuments(JsonNode inputRoot) {
		List<SentimentDocument> documents = new ArrayList<>();

		Iterator<JsonNode> messages = inputRoot.elements();
		for(int i = 0; messages.hasNext(); i++) {
			String message = messages.next().get("fullText").asText();
			documents.add(new SentimentDocument(String.valueOf(i), message, nlp.analyzeSentiment(message)));
		}

		return documents;
	}
}
