package com.spring.boot.kickstart.bicycleproject.service.impl;

import java.util.List;
import java.util.Optional;

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
        if (getBikeById(id).isPresent()) {
            repository.deleteById(id);
        } else {
            throw new BikeNotFoundException(id);
        }
    }

    @Override
    public Bike updateBikeById(final Bike bike, final int id) {
        return getBikeById(id).map(currentBike -> {
            currentBike.setName(bike.getName());
            currentBike.setBrand(bike.getBrand());
            currentBike.setPrice(bike.getPrice());
            currentBike.setColor(bike.getColor());
            return repository.save(currentBike);
        }).orElseThrow(() -> new BikeNotFoundException(id));
    }

    @Override
    public Bike findById(final int id) {
        return getBikeById(id).orElseThrow(() -> new BikeNotFoundException(id));
    }

    @Override
    public Optional<List<Bike>> findAllByBrand(final String brand) {
        if(repository.findAllByBrand(brand).get().isEmpty())
            throw new BikeNotFoundException(brand);
        return this.repository.findAllByBrand(brand);
    }

    private Optional<Bike> getBikeById(final int id) {
        return repository.findById(id);
    }

}
