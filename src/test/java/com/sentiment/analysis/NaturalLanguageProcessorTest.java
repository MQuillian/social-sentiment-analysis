package com.sentiment.analysis;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NaturalLanguageProcessorTest {

	private final NaturalLanguageProcessor nlp = new NaturalLanguageProcessor();

	@Test
	public void analyzeSentiment_GivenPositiveMsg_ShouldReturnIntGreaterThanTwo() {
		assertThat(nlp.analyzeSentiment("This is a very positive, good message.")).isGreaterThan(2);
	}

	@Test
	public void analyzeSentiment_GivenPositiveMsg_ShouldReturnIntLessThanTwo() {
		assertThat(nlp.analyzeSentiment("This is a really awful, terrible message.")).isLessThan(2);
	}

	@Test
	public void analyzeSentiment_GivenNeutralMsg_ShouldReturnIntEqualToTwo() {
		assertThat(nlp.analyzeSentiment("This is a neutral or ambiguous message.")).isEqualTo(2);
	}

	@Test
	public void analyzeSentiment_GivenEmptyMsg_ShouldThrowIllegalArgException() {
		assertThatThrownBy(() -> nlp.analyzeSentiment("")).isInstanceOf(IllegalArgumentException.class)
			.hasMessage("CoreNLP could not analyze sentiment");
	}

	@Test
	public void analyzeSentiment_GivenNullMsg_ShouldThrowIllegalArgException() {
		assertThatThrownBy(() -> nlp.analyzeSentiment(null)).isInstanceOf(IllegalArgumentException.class)
			.hasMessage("Message for analysis cannot be null");
	}
}
