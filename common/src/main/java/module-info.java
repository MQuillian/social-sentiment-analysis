module sentiment.common.main {
	opens com.sentiment.common.application to spring.core;

	requires sentiment.webapp.main;

	requires spring.web;
	requires spring.boot;
	requires spring.boot.autoconfigure;
	requires org.apache.tomcat.embed.core;

	exports com.sentiment.common.application to spring.beans, spring.context, spring.web, spring.boot.devtools;
}