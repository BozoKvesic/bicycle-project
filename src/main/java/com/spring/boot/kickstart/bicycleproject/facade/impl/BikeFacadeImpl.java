package com.spring.boot.kickstart.bicycleproject.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.boot.kickstart.bicycleproject.entity.Bike;
import com.spring.boot.kickstart.bicycleproject.entity.Bill;
import com.spring.boot.kickstart.bicycleproject.facade.BikeFacade;
import com.spring.boot.kickstart.bicycleproject.service.BikeService;
import com.spring.boot.kickstart.bicycleproject.service.BillService;

@Component
public class BikeFacadeImpl implements BikeFacade {

    @Autowired
    private BikeService bikeService;

    @Autowired
    private BillService billService;

    @Override
    public Bike createNewBike(final Bike bike) {
        return bikeService.createNewBike(bike);
    }

    @Override
    public List<Bike> getAllBikes() {
        return bikeService.getAllBikes();
    }

    @Override
    public void deleteById(final int id) {
        bikeService.deleteById(id);
    }

    @Override
    public Bike updateBikeById(final Bike bike, final int id) {
        return bikeService.updateBikeById(bike, id);
    }

    @Override
    public Bike findById(final int id) {
        return bikeService.findById(id);
    }

    @Override
    public List<Bike> findAllByBrand(final String brand) {
        return bikeService.findAllByBrand(brand);
    }

    @Override
    public Bill billOrderBikes(final List<Bike> purchasedBicycles) {
        return bikeService.billOrderBikes(purchasedBicycles);
    }

}
