package com.spring.boot.kickstart.bicycleproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.kickstart.bicycleproject.entity.Bike;
import com.spring.boot.kickstart.bicycleproject.facade.BikeFacade;

@RestController
public class BikeController {

    @Autowired
    private BikeFacade bikeFacade;

    @PostMapping("/bikes")
    public Bike newBike(@RequestBody final Bike newBike) {
        return this.bikeFacade.newBike(newBike);
    }

}
