package org.demo.elasticsearch.gateway;

import lombok.RequiredArgsConstructor;
import org.demo.elasticsearch.domain.Beer;
import org.demo.elasticsearch.gateway.data.BeerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BeerGateway {

    private final BeerRepository beerRepository;

    public List<Beer> findByType(final String type) {
        return beerRepository.findByType(type);
    }

    public void save(final Beer beer) {
        beerRepository.save(beer);
    }

}