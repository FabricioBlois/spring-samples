package org.demo.neo4j.gateway.http;

import lombok.RequiredArgsConstructor;
import org.demo.neo4j.domain.Beer;
import org.demo.neo4j.usecase.BeerUseCase;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/v1/beer")
@RequiredArgsConstructor
public class BeerController {

    private final BeerUseCase beerUseCase;

    @PutMapping(value = "/create", consumes = APPLICATION_JSON_VALUE)
    public void save(@RequestBody final Beer beer) {
        beerUseCase.save(beer);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Beer> findAll() {
        return beerUseCase.findAll();
    }

}