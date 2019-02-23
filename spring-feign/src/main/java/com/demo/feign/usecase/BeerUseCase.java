package com.demo.feign.usecase;

import com.demo.feign.domain.Beer;
import com.demo.feign.gateway.BeerGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BeerUseCase {

    private final BeerGateway beerGateway;

    public List<Beer> findAll () {
        return beerGateway.findAll();
    }


}