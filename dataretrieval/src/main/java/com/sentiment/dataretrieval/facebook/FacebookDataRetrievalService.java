package com.sentiment.dataretrieval.facebook;

import com.sentiment.dataretrieval.external.DataRetrievalService;
import org.springframework.stereotype.Service;

@Service
public class FacebookDataRetrievalService implements DataRetrievalService {

	public FacebookDataRetrievalService() {
	}

	public String fetchData() {
		return "lowercase data from fb";
	}
}
