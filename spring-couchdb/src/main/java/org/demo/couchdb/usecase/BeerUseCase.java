package org.demo.couchdb.usecase;

import lombok.RequiredArgsConstructor;
import org.demo.couchdb.domain.Beer;
import org.demo.couchdb.gateway.BeerGateway;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BeerUseCase {

    private final BeerGateway beerGateway;

    public void save(final Beer beer) {
        beerGateway.save(beer);
    }

    public List<Beer> findByName(final String name) {
        return beerGateway.findByName(name);
    }

}