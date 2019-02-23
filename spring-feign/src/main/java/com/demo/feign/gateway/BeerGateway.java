package com.demo.feign.gateway;

import com.demo.feign.domain.Beer;
import com.demo.feign.gateway.feign.BeerClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BeerGateway {

    private final BeerClient beerClient;

    public List<Beer> findAll() {
        return beerClient.findAll();
    }

}