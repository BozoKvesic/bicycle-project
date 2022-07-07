package com.spring.boot.kickstart.bicycleproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.boot.kickstart.bicycleproject.facade.BikeFacade;

@Controller
public class BikeViewController {

    @Autowired
    private BikeFacade bikeFacade;

    @RequestMapping(value = "/getAllBikes", method = RequestMethod.GET)
    public String getAllBikes(final Model model) {
        model.addAttribute("bikes", bikeFacade.getAllBikes());
        return "bike";
    }

}
