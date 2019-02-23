package org.demo.mongodb.gateway.data;

import org.bson.types.ObjectId;
import org.demo.mongodb.domain.Beer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface BeerRepository extends MongoRepository<Beer, ObjectId> {

    List<Beer> findByType(String type);

    @Query("{name : ?0}")
    List<Beer> findByName(String name);

}