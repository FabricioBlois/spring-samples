package org.demo.mysql.usecase;

import lombok.RequiredArgsConstructor;
import org.demo.mysql.domain.Beer;
import org.demo.mysql.gateway.BeerGateway;
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

}