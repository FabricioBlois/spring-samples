package org.demo.rabbitmq.gateway.http;

import lombok.RequiredArgsConstructor;
import org.demo.rabbitmq.domain.Beer;
import org.demo.rabbitmq.usecase.BeerUseCase;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/api/v1/beer/")
@RequiredArgsConstructor
public class BeerController {

    private final BeerUseCase beerUseCase;

    @PutMapping(value = "/create", consumes = APPLICATION_JSON_VALUE)
    public void publish(@RequestBody final Beer beer) {
        beerUseCase.publish(beer);
    }

}