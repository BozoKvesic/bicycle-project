package com.spring.boot.kickstart.bicycleproject.service;

import java.util.List;

import com.spring.boot.kickstart.bicycleproject.entity.Bike;

public interface BikeService {

    Bike createNewBike(Bike bike);

    List<Bike> getAllBikes();

}
