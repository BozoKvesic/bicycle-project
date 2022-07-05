package com.spring.boot.kickstart.bicycleproject.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.kickstart.bicycleproject.entity.Bike;
import com.spring.boot.kickstart.bicycleproject.entity.Bill;
import com.spring.boot.kickstart.bicycleproject.exception.BillNotFoundException;
import com.spring.boot.kickstart.bicycleproject.repository.BillRepository;
import com.spring.boot.kickstart.bicycleproject.service.BillService;

@Service
public class BillServiceImpl implements BillService {

    @Autowired
    private BillRepository repository;

    @Override
    public Bill createNewBill(final int totalPrice, final List<Bike> purchasedBicycles) {
        return repository.save(new Bill(LocalDate.now(), totalPrice, purchasedBicycles));
    }

    @Override
    public List<Bill> findAll(final LocalDate dateOfPurchase) {

        if (dateOfPurchase != null) {
            if (!repository.findAllByDateOfPurchase(dateOfPurchase).isEmpty()) {
                return repository.findAllByDateOfPurchase(dateOfPurchase);
            }
            throw new BillNotFoundException(dateOfPurchase);
        } else if (!repository.findAll().isEmpty()) {
            return repository.findAll();
        }
        throw new BillNotFoundException();
    }

}
