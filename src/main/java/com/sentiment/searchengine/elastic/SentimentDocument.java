package com.sentiment.searchengine.elastic;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "sentiment")
public class SentimentDocument {

	public SentimentDocument(String id, String content, int sentiment) {
		this.id = id;
		this.content = content;
		this.sentiment = sentiment;
	}

	@Id
	private String id;

	private String content;

	private int sentiment;
}
