package com.sentiment.dataprocessing.external;

import com.sentiment.dataprocessing.service.ElasticSearchRepository;

public class ProcessedDataRepoFactory {

	private ProcessedDataRepoFactory() {}

	public static ProcessedDataRepository getProcessedDataRepo(String sourceName) {
		if(sourceName.equalsIgnoreCase("elasticsearch")) {
			return new ElasticSearchRepository();
		}

		return null;
	}
}
