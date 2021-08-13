package com.sentiment.searchengine.elastic;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "sentiment")
public class SentimentDocument {

	@Id
	private String id;

	private String content;

	private int sentiment;

	private double confidence;
}
