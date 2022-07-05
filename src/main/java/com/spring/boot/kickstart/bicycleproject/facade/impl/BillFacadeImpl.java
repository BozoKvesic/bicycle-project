package com.spring.boot.kickstart.bicycleproject.facade.impl;

import java.time.LocalDate;
import java.util.List;

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
    public List<Bill> findAll() {
        return billService.findAll();
    }

    @Override
    public List<Bill> findAllOnSpecificDate(final LocalDate dateOfPurchase) {
        if (dateOfPurchase != null) {
            return billService.findAllOnSpecificDate(dateOfPurchase);
        }
        throw new BillNotFoundException(dateOfPurchase);

    }

}
