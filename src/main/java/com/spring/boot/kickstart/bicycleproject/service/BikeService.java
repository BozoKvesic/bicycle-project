package com.spring.boot.kickstart.bicycleproject.service;

import java.util.List;

import com.spring.boot.kickstart.bicycleproject.entity.Bike;
import com.spring.boot.kickstart.bicycleproject.entity.Bill;

public interface BikeService {

    Bike createNewBike(Bike bike);

    List<Bike> getAllBikes();

    void deleteById(int id);

    Bike updateBikeById(Bike bike, int id);

    Bike findById(int id);

    List<Bike> findAllByBrand(String brand);

    Bill orderBikes(List<Bike> purchasedBicycles);

}
