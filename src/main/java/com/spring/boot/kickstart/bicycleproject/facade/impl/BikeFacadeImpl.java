package com.spring.boot.kickstart.bicycleproject.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.kickstart.bicycleproject.entity.Bike;
import com.spring.boot.kickstart.bicycleproject.facade.BikeFacade;
import com.spring.boot.kickstart.bicycleproject.service.BikeService;

@Service
public class BikeFacadeImpl implements BikeFacade {

    @Autowired
    private BikeService bikeService;

    @Override
    public Bike newBike(final Bike bike) {
        return this.bikeService.newBike(bike);
    }

}
