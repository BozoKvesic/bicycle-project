package com.spring.boot.kickstart.bicycleproject.facade;

import java.util.List;
import java.util.Optional;

import com.spring.boot.kickstart.bicycleproject.entity.Bike;

public interface BikeFacade {

    Bike createNewBike(Bike bike);

    List<Bike> getAllBikes();

    void deleteById(int id);

    Bike updateBikeById(Bike bike, int id);

    Bike findById(int id);

    Optional<List<Bike>> findAllByBrand(String brand);

}
