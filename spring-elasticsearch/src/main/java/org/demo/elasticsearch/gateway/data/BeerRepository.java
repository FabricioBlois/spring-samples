package org.demo.elasticsearch.gateway.data;

import org.demo.elasticsearch.domain.Beer;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BeerRepository extends ElasticsearchRepository<Beer, String> {

    List<Beer> findByType(String type);

}