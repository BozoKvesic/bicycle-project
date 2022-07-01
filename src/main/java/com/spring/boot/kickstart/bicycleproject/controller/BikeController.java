package com.spring.boot.kickstart.bicycleproject.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.kickstart.bicycleproject.entity.Bike;
import com.spring.boot.kickstart.bicycleproject.repository.BikeRepository;

@RestController
public class BikeController {

    private final BikeRepository repository;

    BikeController(final BikeRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/bikes")
    Bike newBike(@RequestBody final Bike newBike) {
        return this.repository.save(newBike);
    }

}
