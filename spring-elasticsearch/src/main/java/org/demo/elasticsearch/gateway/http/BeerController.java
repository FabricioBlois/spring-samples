package org.demo.elasticsearch.gateway.http;

import lombok.RequiredArgsConstructor;
import org.demo.elasticsearch.domain.Beer;
import org.demo.elasticsearch.usecase.BeerUseCase;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/api/v1/beer")
@RequiredArgsConstructor
public class BeerController {

    private final BeerUseCase beerUseCase;

    @GetMapping(value = "/type/{type}", produces = APPLICATION_JSON_VALUE)
    public List<Beer> findByType(@PathVariable final String type) {
        return beerUseCase.findByType(type);
    }

    @PutMapping(value = "/create", consumes = APPLICATION_JSON_VALUE)
    public void save(@RequestBody final Beer beer) {
        beerUseCase.save(beer);
    }

}