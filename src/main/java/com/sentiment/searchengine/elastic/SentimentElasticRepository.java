package com.sentiment.searchengine.elastic;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface SentimentElasticRepository extends ElasticsearchRepository<SentimentDocument, String> {
}
