package com.reactive.app;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DogService {
    @Autowired
    private DogRepository dogRepository;

    public Mono<Dog> create(Dog dog) {
        System.out.println(Thread.currentThread().getName());

        return dogRepository.save(dog).doOnNext(data -> {
            System.out.println(Thread.currentThread().getName());
        });
    }

    public Flux<Dog> getAll() {
        return dogRepository
                .findAll()
                .log()
                .delayElements(Duration.ofSeconds(2))
                .map(dog -> {
                    dog.setBreed(dog.getBreed().toUpperCase());
                    return dog;
                });
    }

    public Mono<Dog> get(int dogId) {
        return dogRepository.findById(dogId);
    }

    public Mono<Dog> update(Dog dog, int dogId) {
        Mono<Dog> oldDog = dogRepository.findById(dogId);

        return oldDog.flatMap(dog1 -> {
            dog1.setName(dog.getName());
            dog1.setBreed(dog.getBreed());
            dog1.setOrigin(dog.getOrigin());

            return dogRepository.save(dog1);
        });
    }

    public Mono<Void> delete(int dogId) {
        Mono<Dog> dogMono = dogRepository.findById(dogId);

        return dogMono.flatMap(dog -> {
            return dogRepository.delete(dog);
        });

    }

}
