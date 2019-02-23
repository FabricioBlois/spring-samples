package org.demo.cassandra.gateway.impl;

import lombok.RequiredArgsConstructor;
import org.demo.cassandra.domain.Beer;
import org.demo.cassandra.gateway.BeerGateway;
import org.demo.cassandra.gateway.data.BeerRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BeerGatewayImpl implements BeerGateway {

    private final BeerRepository beerRepository;

    @Override
    public void save(final Beer beer) {
        beerRepository.save(beer);
    }

    @Override
    public List<Beer> findAll() {
        return beerRepository.findAll();
    }

    @Override
    public List<Beer> findByName(final String name) {
        return beerRepository.findByName(name);
    }

}