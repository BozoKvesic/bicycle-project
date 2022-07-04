package com.spring.boot.kickstart.bicycleproject.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.spring.boot.kickstart.bicycleproject.entity.Bike;
import com.spring.boot.kickstart.bicycleproject.facade.BikeFacade;
import com.spring.boot.kickstart.bicycleproject.service.BikeService;

@Component
public class BikeFacadeImpl implements BikeFacade {

    @Autowired
    private BikeService bikeService;

    @Override
    public Bike createNewBike(final Bike bike) {
        return this.bikeService.createNewBike(bike);
    }

    @Override
    public List<Bike> getAllBikes() {
        return this.bikeService.getAllBikes();
    }

}
