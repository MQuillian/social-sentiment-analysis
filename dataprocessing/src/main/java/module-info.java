module sentiment.dataprocessing.main {
	requires java.annotation;
	requires spring.boot;
	requires spring.beans;
	requires spring.context;

	exports com.sentiment.dataprocessing.external to sentiment.webapp.main;
	exports com.sentiment.dataprocessing.service to spring.beans, spring.boot;
}