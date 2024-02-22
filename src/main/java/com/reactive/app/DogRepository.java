package com.reactive.app;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogRepository extends ReactiveCrudRepository<Dog, Integer> {

}
