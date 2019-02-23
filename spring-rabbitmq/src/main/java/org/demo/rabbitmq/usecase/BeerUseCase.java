package org.demo.rabbitmq.usecase;

import lombok.RequiredArgsConstructor;
import org.demo.rabbitmq.domain.Beer;
import org.demo.rabbitmq.gateway.BeerGateway;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BeerUseCase {

    private final BeerGateway beerGateway;

    public void publish(final Beer beer) {
        beerGateway.publish(beer, "ha.input.beer");
    }

}