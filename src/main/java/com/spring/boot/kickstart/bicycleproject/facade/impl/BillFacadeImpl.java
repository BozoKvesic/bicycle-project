package com.spring.boot.kickstart.bicycleproject.facade.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.boot.kickstart.bicycleproject.entity.Bill;
import com.spring.boot.kickstart.bicycleproject.exception.BillNotFoundException;
import com.spring.boot.kickstart.bicycleproject.facade.BillFacade;
import com.spring.boot.kickstart.bicycleproject.service.BillService;

@Component
public class BillFacadeImpl implements BillFacade {

    @Autowired
    private BillService billService;

    @Override
    public List<Bill> findAllBills() {
        return billService.findAllBills();
    }

    @Override
    public List<Bill> findAllOnSpecificDate(final LocalDate dateOfPurchase) {
        if (dateOfPurchase != null) {
            return billService.findAllOnSpecificDate(dateOfPurchase);
        }
        throw new BillNotFoundException(dateOfPurchase);

    }

    @Override
    public Map<String, Float> getStatistic(final String brand, final String color) {
        if (brand != null && color != null) {
            return billService.getStatistic(brand, color);
        } else if (brand != null) {
            return billService.getStatisticBrand(brand);
        } else if (color != null) {
            return billService.getStatisticColor(color);
        }
        throw new BillNotFoundException();
    }

}
