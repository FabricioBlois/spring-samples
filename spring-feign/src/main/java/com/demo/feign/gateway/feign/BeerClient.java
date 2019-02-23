package com.demo.feign.gateway.feign;

import com.demo.feign.domain.Beer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@FeignClient(name = "${endpoints.spring.name}")
public interface BeerClient {

    @GetMapping(value = "/api/v1/beer", produces = APPLICATION_JSON_VALUE)
    List<Beer> findAll();

}