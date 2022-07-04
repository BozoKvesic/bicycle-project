package com.spring.boot.kickstart.bicycleproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.kickstart.bicycleproject.entity.Bike;
import com.spring.boot.kickstart.bicycleproject.facade.BikeFacade;

@RestController
public class BikeController {

    @Autowired
    private BikeFacade bikeFacade;

    @PostMapping("/bikes")
    public Bike createNewBike(@RequestBody final Bike bike) {
        return this.bikeFacade.createNewBike(bike);
    }

    @GetMapping("/bikes")
    List<Bike> getAllBikes() {
        return this.bikeFacade.getAllBikes();
    }

    @DeleteMapping("/bikes/{id}")
    void deleteBike(@PathVariable final int id) {
        this.bikeFacade.deleteById(id);
    }

    @PutMapping("/bikes/{id}")
    Bike updateBikeById(@RequestBody final Bike bike, @PathVariable int id) {

        return this.bikeFacade.updateBikeById(bike, id);

    }

}
