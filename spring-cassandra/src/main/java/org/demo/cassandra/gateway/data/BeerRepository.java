package org.demo.cassandra.gateway.data;

import org.demo.cassandra.domain.Beer;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.List;

public interface BeerRepository extends CassandraRepository<Beer, String> {

    List<Beer> findByName(String name);

}