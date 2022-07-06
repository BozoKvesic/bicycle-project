package com.spring.boot.kickstart.bicycleproject.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.kickstart.bicycleproject.entity.Bill;
import com.spring.boot.kickstart.bicycleproject.facade.BillFacade;

@RestController
public class BillController {

    @Autowired
    private BillFacade billFacade;

    @GetMapping("/bills")
    List<Bill> getAllBills() {
        return billFacade.findAllBills();
    }

    @GetMapping("/bills/{dateOfPurchase}")
    List<Bill> getAllBillsOnDateOfPurchase(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) final LocalDate dateOfPurchase) {
        return billFacade.findAllOnSpecificDate(dateOfPurchase);
    }

    @GetMapping("/statistic")
    Map<String, Float> getStatistic(@RequestParam(value = "brand", required = false) final String brand, @RequestParam(value = "color", required = false) final String color) {
        return billFacade.getStatistic(brand, color);
    }

}
