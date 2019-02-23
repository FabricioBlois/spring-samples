package org.demo.mysql.gateway.data;

import org.demo.mysql.domain.Beer;
import org.springframework.data.repository.CrudRepository;

public interface BeerRepository extends CrudRepository<Beer, Integer> {

}