package com.sentiment.dataprocessing.service;

import com.sentiment.dataprocessing.external.ProcessedDataRepository;
import org.springframework.stereotype.Service;

@Service
public class ElasticSearchRepository implements ProcessedDataRepository {

	public ElasticSearchRepository() {
	}

	public String processData(String unprocessedData) {
		return unprocessedData.toUpperCase();
	}
}
