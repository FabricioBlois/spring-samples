package org.demo.couchdb.gateway.data;

import org.demo.couchdb.domain.Beer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BeerRepository extends CrudRepository<Beer, String> {

    List<Beer> findByName(String name);

}