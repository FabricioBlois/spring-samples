package org.demo.neo4j.gateway.data;

import org.demo.neo4j.domain.Beer;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface BeerRepository extends Neo4jRepository<Beer, Long> {

}