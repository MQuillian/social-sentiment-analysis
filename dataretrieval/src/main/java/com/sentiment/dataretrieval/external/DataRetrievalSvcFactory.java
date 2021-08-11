package com.sentiment.dataretrieval.external;

import com.sentiment.dataretrieval.dummy.DummyDataRetrievalService;
import com.sentiment.dataretrieval.facebook.FacebookDataRetrievalService;

public class DataRetrievalSvcFactory {

	private DataRetrievalSvcFactory() {}

	public static DataRetrievalService getDataRetrievalSvc(String serviceName) {
		if(serviceName.equalsIgnoreCase("facebook")) {
			return new FacebookDataRetrievalService();
		} else if(serviceName.equalsIgnoreCase("dummy")) {
			return new DummyDataRetrievalService();
		}

		return null;
	}
}
