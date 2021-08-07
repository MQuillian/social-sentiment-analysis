module sentiment.webapp.main {
	requires sentiment.dataretrieval.main;
	requires sentiment.dataprocessing.main;

	requires java.annotation;
	requires spring.web;
	requires spring.boot;
	requires spring.boot.autoconfigure;
	requires spring.beans;
	requires spring.context;

	exports com.sentiment.webapp.service;
}