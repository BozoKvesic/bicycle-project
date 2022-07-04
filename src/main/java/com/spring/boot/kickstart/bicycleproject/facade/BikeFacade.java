package com.spring.boot.kickstart.bicycleproject.facade;

import java.util.List;

import com.spring.boot.kickstart.bicycleproject.entity.Bike;

public interface BikeFacade {

    Bike createNewBike(Bike bike);

    List<Bike> getAllBikes();

}
