package com.sentiment.webapp.service;

import com.sentiment.dataprocessing.external.ProcessedDataRepoFactory;
import com.sentiment.dataprocessing.external.ProcessedDataRepository;
import com.sentiment.dataretrieval.external.DataRetrievalService;
import com.sentiment.dataretrieval.external.DataRetrievalSvcFactory;
import org.springframework.stereotype.Service;

@Service
public class DataServiceImpl implements DataService {

	private final DataRetrievalService svc;
	private final ProcessedDataRepository repo;

	public DataServiceImpl() {
		this.svc = DataRetrievalSvcFactory.getDataRetrievalSvc("dummy");
		this.repo = ProcessedDataRepoFactory.getProcessedDataRepo("elasticsearch");
	}

	public String message() {
		String unprocessed = svc.fetchData();
		return repo.processData(unprocessed);
	}
}
