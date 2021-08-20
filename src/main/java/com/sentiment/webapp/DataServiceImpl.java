package com.sentiment.webapp;

import com.sentiment.dataretrieval.common.DataRetrievalService;
import com.sentiment.dataretrieval.dummy.DummyDataRetrievalService;
import com.sentiment.searchengine.common.SearchService;
import com.sentiment.searchengine.elastic.ElasticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class DataServiceImpl implements DataService {

	private final DataRetrievalService retrievalService;
	private final SearchService searchService;

	@Autowired
	public DataServiceImpl(@Qualifier("dummy")DataRetrievalService retrievalService, @Qualifier("elastic")SearchService searchService) {
		this.retrievalService = retrievalService;
		this.searchService = searchService;
	}

	public String message() {
		String unprocessed = retrievalService.fetchData();
		try {
			return searchService.processData(unprocessed);

		} catch(Exception e) {
			return e.getClass().toString() + " - " + e.getMessage();
		}
	}
}
