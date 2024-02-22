package com.reactive.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/dogs")
public class DogController {
    @Autowired
    private DogService dogService;

    @PostMapping
    public Mono<Dog> create(@RequestBody Dog dog) {
        return dogService.create(dog);
    }

    @GetMapping
    public Flux<Dog> getAll() {
        return dogService.getAll();
    }

    @GetMapping("/{dogId}")
    public Mono<Dog> get(@PathVariable int dogId) {
        return dogService.get(dogId);
    }

    @PutMapping("/{dogId}")
    public Mono<Dog> update(@RequestBody Dog dog, @PathVariable int dogId) {
        return dogService.update(dog, dogId);
    }

    @DeleteMapping("/{dogId}")
    public Mono<Void> delete(@PathVariable int dogId) {
        return dogService.delete(dogId);
    }
}
