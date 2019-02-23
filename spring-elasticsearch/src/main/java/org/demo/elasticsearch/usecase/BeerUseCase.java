package org.demo.elasticsearch.usecase;

import lombok.RequiredArgsConstructor;
import org.demo.elasticsearch.domain.Beer;
import org.demo.elasticsearch.gateway.BeerGateway;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BeerUseCase {

    private final BeerGateway beerGateway;

    public List<Beer> findByType(final String type) {
        return beerGateway.findByType(type);
    }

    public void save(final Beer beer) {
        beerGateway.save(beer);
    }

}