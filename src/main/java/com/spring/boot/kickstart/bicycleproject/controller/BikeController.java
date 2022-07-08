package com.spring.boot.kickstart.bicycleproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.boot.kickstart.bicycleproject.entity.Bike;
import com.spring.boot.kickstart.bicycleproject.entity.Bill;
import com.spring.boot.kickstart.bicycleproject.facade.BikeFacade;
import com.spring.boot.kickstart.bicycleproject.facade.BillFacade;

@Controller
public class BikeController {

    @Autowired
    private BikeFacade bikeFacade;

    @Autowired
    private BillFacade billFacade;

    @PostMapping(value = "/bikes")
    public @ResponseBody Bike createNewBike(@RequestBody final Bike bike) {
        return bikeFacade.createNewBike(bike);
    }

    @GetMapping(value = "/bikes")
    public @ResponseBody List<Bike> getAllBikes() {
        return bikeFacade.getAllBikes();
    }

    @DeleteMapping(value = "/bikes/{id}")
    @ResponseBody
    void deleteBike(@PathVariable final int id) {
        bikeFacade.deleteById(id);
    }

    @PutMapping(value = "/bikes/{id}")
    @ResponseBody
    Bike updateBikeById(@RequestBody final Bike bike, @PathVariable final int id) {
        return bikeFacade.updateBikeById(bike, id);
    }

    @GetMapping(value = "/bikes/{id}")
    @ResponseBody
    Bike getOneBike(@PathVariable final int id) {
        return bikeFacade.findById(id);
    }

    @GetMapping(value = "/bikes/brand/{brand}")
    @ResponseBody
    List<Bike> getAllBrands(@PathVariable final String brand) {
        return bikeFacade.findAllByBrand(brand);
    }

    @PostMapping(value = "/bills")
    @ResponseBody
    Bill orderBikes(@RequestBody final List<Bike> purchasedBicycles) {
        return bikeFacade.orderBikes(purchasedBicycles);
    }

    @GetMapping(value = "/getAllBikes")
    public String getAllBikes(final Model model) {
        model.addAttribute("bikes", bikeFacade.getAllBikes());
        return "bike";
    }

    @GetMapping(value = "/getAllBills")
    public String getAllBills(final Model model) {
        model.addAttribute("bills", billFacade.findAllBills());
        return "bill";
    }

}
