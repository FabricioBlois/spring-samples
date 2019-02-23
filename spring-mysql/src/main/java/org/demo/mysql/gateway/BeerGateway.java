package org.demo.mysql.gateway;

import lombok.RequiredArgsConstructor;
import org.demo.mysql.domain.Beer;
import org.demo.mysql.gateway.data.BeerRepository;
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
                        .build()));

        return beers;
    }

}