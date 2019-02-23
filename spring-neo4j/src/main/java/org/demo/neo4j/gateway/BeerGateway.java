package org.demo.neo4j.gateway;

import lombok.RequiredArgsConstructor;
import org.demo.neo4j.domain.Beer;
import org.demo.neo4j.gateway.data.BeerRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class BeerGateway {

    private final BeerRepository beerRepository;

    public void save(final Beer beer) {
        beerRepository.save(beer);
    }

    public List<Beer> findAll() {
        final List<Beer> beers = new ArrayList<>();

        beerRepository
                .findAll()
                .forEach(beer -> beers.add(Beer
                        .builder()
                        .id(beer.getId())
                        .name(beer.getName())
                        .type(beer.getType())
                        .water(beer.getWater())
                        .malts(beer.getMalts())
                        .hops(beer.getHops())
                        .yeast(beer.getYeast())
                        .build()));

        return beers;
    }

}