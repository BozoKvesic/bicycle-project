package com.spring.boot.kickstart.bicycleproject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.kickstart.bicycleproject.entity.Bike;
import com.spring.boot.kickstart.bicycleproject.repository.BikeRepository;
import com.spring.boot.kickstart.bicycleproject.service.BikeService;

@Service
public class BikeServiceImpl implements BikeService {

    @Autowired
    private BikeRepository repository;

    @Override
    public Bike createNewBike(final Bike bike) {
        return this.repository.save(bike);
    }

}
