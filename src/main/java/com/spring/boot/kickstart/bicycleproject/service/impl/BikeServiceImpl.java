package com.spring.boot.kickstart.bicycleproject.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.kickstart.bicycleproject.entity.Bike;
import com.spring.boot.kickstart.bicycleproject.entity.Bill;
import com.spring.boot.kickstart.bicycleproject.exception.BikeNotFoundException;
import com.spring.boot.kickstart.bicycleproject.repository.BikeRepository;
import com.spring.boot.kickstart.bicycleproject.service.BikeService;
import com.spring.boot.kickstart.bicycleproject.service.BillService;

@Service
public class BikeServiceImpl implements BikeService {

    @Autowired
    private BikeRepository repository;

    @Autowired
    private BillService billService;

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
    public List<Bike> findAllByBrand(final String brand) {
        if (!repository.findAllByBrand(brand).isEmpty()) {
            return repository.findAllByBrand(brand);
        }
        throw new BikeNotFoundException(brand);
    }

    @Override
    public Bill billOrderBikes(final List<Bike> purchasedBicycles) {
        int totalPrice = 0;
        for (final Bike bike : purchasedBicycles) {
            totalPrice += bike.getPrice();
        }
        return billService.createNewBill(totalPrice, purchasedBicycles);
    }

    private Optional<Bike> getBikeById(final int id) {
        return repository.findById(id);
    }

}
