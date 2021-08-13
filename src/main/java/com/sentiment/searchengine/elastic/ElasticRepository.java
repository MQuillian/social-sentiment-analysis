package com.sentiment.searchengine.elastic;

import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ElasticRepository {

	Page<String> findAll();
}
