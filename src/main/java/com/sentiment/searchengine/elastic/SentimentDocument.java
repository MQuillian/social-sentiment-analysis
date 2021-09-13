package com.sentiment.searchengine.elastic;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Document(indexName = "sentiment")
public class SentimentDocument {

	@Id
	private String id;

	private long epochMillisTimestamp;

	private String content;

	private int sentiment;

	public SentimentDocument(String id, long epochMillisTimestamp, String content, int sentiment) {
		this.id = id;
		this.epochMillisTimestamp = epochMillisTimestamp;
		this.content = content;
		this.sentiment = sentiment;
	}

	public SentimentDocument(String id, String content, int sentiment) {
		this(id, (LocalDateTime.now().toEpochSecond(ZoneOffset.UTC) * 1000), content, sentiment);
	}
}
