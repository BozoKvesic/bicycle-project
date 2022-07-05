package com.spring.boot.kickstart.bicycleproject.facade;

import java.time.LocalDate;
import java.util.List;

import com.spring.boot.kickstart.bicycleproject.entity.Bill;

public interface BillFacade {

    List<Bill> findAll(final LocalDate dateOfPurchase);

}
