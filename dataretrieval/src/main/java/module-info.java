module sentiment.dataretrieval.main {
	requires java.annotation;
	requires spring.boot;
	requires spring.beans;
	requires spring.context;
	requires spring.core;
	requires com.fasterxml.jackson.databind;

	exports com.sentiment.dataretrieval.external to sentiment.webapp.main;
	exports com.sentiment.dataretrieval.facebook to spring.beans, spring.boot;
}