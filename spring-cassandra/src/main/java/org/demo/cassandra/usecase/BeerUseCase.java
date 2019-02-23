package org.demo.cassandra.usecase;

import lombok.RequiredArgsConstructor;
import org.demo.cassandra.domain.Beer;
import org.demo.cassandra.gateway.BeerGateway;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BeerUseCase {

    private final BeerGateway beerGateway;

    public void save(final Beer beer) {
        beerGateway.save(beer);
    }

    public List<Beer> findAll() {
        return beerGateway.findAll();
    }

    public List<Beer> findByName(final String name) {
        return beerGateway.findByName(name);
    }

}