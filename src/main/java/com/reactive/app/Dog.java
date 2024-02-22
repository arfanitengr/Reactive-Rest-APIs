package com.reactive.app;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("dogs")
public class Dog {
    @Id
    @Column("dog_id")
    private int id;
    @Column("dog_name")
    private String name;
    private String breed;
    private String origin;

    public Dog() {
    }

    public Dog(int id, String name, String breed, String origin) {
        this.id = id;
        this.name = name;
        this.breed = breed;
        this.origin = origin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

}