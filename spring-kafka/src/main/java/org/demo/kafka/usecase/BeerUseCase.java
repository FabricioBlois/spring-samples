package org.demo.kafka.usecase;

import lombok.RequiredArgsConstructor;
import org.demo.kafka.domain.Beer;
import org.demo.kafka.gateway.BeerGateway;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BeerUseCase {

    private final BeerGateway beerGateway;

    public void publish(final Beer beer) {
        beerGateway.publish(beer);
    }

}