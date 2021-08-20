package com.sentiment.analysis;

import com.fasterxml.jackson.databind.JsonNode;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.neural.rnn.RNNCoreAnnotations;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.sentiment.SentimentCoreAnnotations;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.util.CoreMap;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.Properties;

@Component
public class NaturalLanguageProcessor {
	private StanfordCoreNLP nlp;

	public NaturalLanguageProcessor() {
		Properties props = new Properties();
		props.setProperty("annotators", "tokenize, ssplit, pos, parse, sentiment");
		this.nlp = new StanfordCoreNLP(props);
	}

	public int analyzeSentiment(String message) throws IllegalArgumentException {
		if(message == null) {
			throw new IllegalArgumentException("Message for analysis cannot be null");
		}
		int sentiment = -1;

		Annotation annotation = nlp.process(message);
		for(CoreMap sentence : annotation.get(CoreAnnotations.SentencesAnnotation.class)) {
			Tree tree = sentence.get(SentimentCoreAnnotations.SentimentAnnotatedTree.class);
			sentiment = RNNCoreAnnotations.getPredictedClass(tree);
		}

		if(sentiment == -1) {
			throw new IllegalArgumentException("CoreNLP could not analyze sentiment");
		}

		return sentiment;
	}
}
