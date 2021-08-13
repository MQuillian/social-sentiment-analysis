package com.sentiment.searchengine.elastic;

import com.sentiment.searchengine.common.SearchService;
import org.springframework.stereotype.Service;

@Service
public class ElasticService implements SearchService {

	public ElasticService() {
	}

	public String processData(String unprocessedData) {
		return unprocessedData.toUpperCase();
	}
}
