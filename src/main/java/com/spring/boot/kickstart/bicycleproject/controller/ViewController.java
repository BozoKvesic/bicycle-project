package com.spring.boot.kickstart.bicycleproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.boot.kickstart.bicycleproject.facade.BikeFacade;
import com.spring.boot.kickstart.bicycleproject.facade.BillFacade;

@Controller
public class ViewController {

    @Autowired
    private BikeFacade bikeFacade;

    @Autowired
    private BillFacade billFacade;

    @RequestMapping(value = "/getAllBikes", method = RequestMethod.GET)
    public String getAllBikes(final Model model) {
        model.addAttribute("bikes", bikeFacade.getAllBikes());
        return "bike";
    }

    @RequestMapping(value = "/getAllBills", method = RequestMethod.GET)
    public String getAllBills(final Model model) {
        model.addAttribute("bills", billFacade.findAllBills());
        return "bill";
    }

}
