package org.demo.mongodb.usecase;

import lombok.RequiredArgsConstructor;
import org.demo.mongodb.domain.Beer;
import org.demo.mongodb.gateway.BeerGateway;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BeerUseCase {

    private final BeerGateway beerGateway;

    public List<Beer> findAll() {
        return beerGateway.findAll();
    }

    public List<Beer> findByType(final String type) {
        return beerGateway.findByType(type);
    }

    public List<Beer> findByName(final String name) {
        return beerGateway.findByName(name);
    }

    public void save(final Beer beer) {
        beerGateway.save(beer);
    }

}