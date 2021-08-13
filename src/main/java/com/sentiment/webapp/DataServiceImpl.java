package com.sentiment.webapp;

import com.sentiment.dataretrieval.common.DataRetrievalService;
import com.sentiment.dataretrieval.dummy.DummyDataRetrievalService;
import com.sentiment.searchengine.common.SearchService;
import com.sentiment.searchengine.elastic.ElasticService;
import org.springframework.stereotype.Service;

@Service
public class DataServiceImpl implements DataService {

	private final DataRetrievalService retrievalService;
	private final SearchService searchService;

	public DataServiceImpl() {
		this.retrievalService = new DummyDataRetrievalService();
		this.searchService = new ElasticService();
	}

	public String message() {
		String unprocessed = retrievalService.fetchData();
		return searchService.processData(unprocessed);
	}
}
