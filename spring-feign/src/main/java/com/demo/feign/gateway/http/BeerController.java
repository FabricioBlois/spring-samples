package com.demo.feign.gateway.http;

import com.demo.feign.domain.Beer;
import com.demo.feign.usecase.BeerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/api/v1/beer")
@RequiredArgsConstructor
public class BeerController {

    private final BeerUseCase beerUseCase;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Beer> findAll() {
        return beerUseCase.findAll();
    }

}