package com.spring.boot.kickstart.bicycleproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.kickstart.bicycleproject.entity.Bike;
import com.spring.boot.kickstart.bicycleproject.entity.Bill;
import com.spring.boot.kickstart.bicycleproject.facade.BikeFacade;

@RestController
public class BikeController {

    @Autowired
    private BikeFacade bikeFacade;

    @PostMapping("/bikes")
    public Bike createNewBike(@RequestBody final Bike bike) {
        return bikeFacade.createNewBike(bike);
    }

    @GetMapping("/bikes")
    public List<Bike> getAllBikes() {
        return bikeFacade.getAllBikes();
    }

    @DeleteMapping("/bikes/{id}")
    void deleteBike(@PathVariable final int id) {
        bikeFacade.deleteById(id);
    }

    @PutMapping("/bikes/{id}")
    Bike updateBikeById(@RequestBody final Bike bike, @PathVariable final int id) {
        return bikeFacade.updateBikeById(bike, id);
    }

    @GetMapping("/bikes/{id}")
    Bike getOneBike(@PathVariable final int id) {
        return bikeFacade.findById(id);
    }

    @GetMapping("/bikes/brand/{brand}")
    List<Bike> getAllBrands(@PathVariable final String brand) {
        return bikeFacade.findAllByBrand(brand);
    }

    @PostMapping("/bills")
    Bill orderBikes(@RequestBody final List<Bike> purchasedBicycles) {
        return bikeFacade.orderBikes(purchasedBicycles);
    }

}
