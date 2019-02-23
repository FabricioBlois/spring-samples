package org.demo.couchdb.gateway;

import lombok.RequiredArgsConstructor;
import org.demo.couchdb.domain.Beer;
import org.demo.couchdb.gateway.data.BeerRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BeerGateway {

    private final BeerRepository beerRepository;

    public void save(final Beer beer) {
        beerRepository.save(beer);
    }

    public List<Beer> findByName(final String name) {
        return beerRepository.findByName(name);
    }

}