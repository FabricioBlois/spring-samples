package org.demo.mongodb.gateway;

import lombok.RequiredArgsConstructor;
import org.demo.mongodb.domain.Beer;
import org.demo.mongodb.gateway.data.BeerRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BeerGateway {

    private final BeerRepository beerRepository;

    public List<Beer> findAll() {
        return beerRepository.findAll();
    }

    public List<Beer> findByType(final String type) {
        return beerRepository.findByType(type);
    }

    public List<Beer> findByName(final String name) {
        return beerRepository.findByName(name);
    }

    public void save(final Beer beer) {
        beerRepository.save(beer);
    }

}