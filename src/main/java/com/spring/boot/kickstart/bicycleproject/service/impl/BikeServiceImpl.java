package com.spring.boot.kickstart.bicycleproject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.kickstart.bicycleproject.entity.Bike;
import com.spring.boot.kickstart.bicycleproject.exception.BikeNotFoundException;
import com.spring.boot.kickstart.bicycleproject.repository.BikeRepository;
import com.spring.boot.kickstart.bicycleproject.service.BikeService;

@Service
public class BikeServiceImpl implements BikeService {

    @Autowired
    private BikeRepository repository;

    @Override
    public Bike createNewBike(final Bike bike) {
        return repository.save(bike);
    }

    @Override
    public List<Bike> getAllBikes() {
        return repository.findAll();
    }

    @Override
    public void deleteById(final int id) {
        if (isBikeExist(id)) {
            repository.deleteById(id);
        } else {
            throw new BikeNotFoundException(id);
        }
    }

    @Override
    public Bike updateBikeById(final Bike bike, final int id) {
        return repository.findById(id).map(currentBike -> {
            currentBike.setName(bike.getName());
            currentBike.setBrand(bike.getBrand());
            currentBike.setPrice(bike.getPrice());
            currentBike.setColor(bike.getColor());
            return repository.save(currentBike);
        }).orElseGet(() -> {
            bike.setId(id);
            return repository.save(bike);
        });
    }

    private boolean isBikeExist(final int id) {
        return repository.findById(id).isPresent();
    }

}
