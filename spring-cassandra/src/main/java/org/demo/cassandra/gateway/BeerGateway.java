package org.demo.cassandra.gateway;

import org.demo.cassandra.domain.Beer;

import java.util.List;

public interface BeerGateway {

    void save(Beer beer);

    List<Beer> findAll();

    List<Beer> findByName(String name);

}