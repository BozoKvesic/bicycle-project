package com.spring.boot.kickstart.bicycleproject.service.impl;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public List<Bill> findAllBills() {
        if (!repository.findAll().isEmpty()) {
            return repository.findAll();
        }
        throw new BillNotFoundException();
    }

    @Override
    public List<Bill> findAllOnSpecificDate(final LocalDate dateOfPurchase) {
        if (!repository.findAllByDateOfPurchase(dateOfPurchase).isEmpty()) {
            return repository.findAllByDateOfPurchase(dateOfPurchase);
        }
        throw new BillNotFoundException(dateOfPurchase);
    }

    @Override
    public Map<String, Float> getStatistic(final String brend, final String color) {
        final int year = Calendar.getInstance().get(Calendar.YEAR);
        final List<Bill> bills = repository.findAll();
        if (bills.isEmpty()) {
            throw new BillNotFoundException();
        }
        List<Bike> bikes;
        float totalSaleCount = 0;
        float brendColorPercentageSale = 0;
        for (final Bill bill : bills) {
            if (bill.getDateOfPurchase().getYear() >= year) {
                bikes = bill.getBikes();

                for (final Bike bike : bikes) {
                    if (bike.getBrand().equals(brend) && bike.getColor().equals(color)) {
                        brendColorPercentageSale += bike.getPrice();
                    }
                }
                totalSaleCount += bill.getTotalPrice();
            }
        }
        final Map<String, Float> map = new HashMap<>();
        if (totalSaleCount != 0) {
            map.put("Color and brend percentage sale", (brendColorPercentageSale * 100) / totalSaleCount);
        }
        return map;
    }

    @Override
    public Map<String, Float> getStatisticBrend(final String brend) {
        final int year = Calendar.getInstance().get(Calendar.YEAR);
        final List<Bill> bills = repository.findAll();
        if (bills.isEmpty()) {
            throw new BillNotFoundException();
        }
        List<Bike> bikes;
        float totalSaleCount = 0;
        float brendPercentageSale = 0;
        for (final Bill bill : bills) {
            if (bill.getDateOfPurchase().getYear() >= year) {
                bikes = bill.getBikes();
                for (final Bike bike : bikes) {
                    if (bike.getBrand().equals(brend)) {
                        brendPercentageSale += bike.getPrice();
                    }
                }
                totalSaleCount += bill.getTotalPrice();
            }
        }
        final Map<String, Float> map = new HashMap<>();
        if (totalSaleCount != 0) {
            map.put("Brend " + brend + " percentage sale", (brendPercentageSale * 100) / totalSaleCount);
        }
        return map;
    }

    @Override
    public Map<String, Float> getStatisticColor(final String color) {
        final int year = Calendar.getInstance().get(Calendar.YEAR);
        final List<Bill> bills = repository.findAll();
        if (bills.isEmpty()) {
            throw new BillNotFoundException();
        }
        List<Bike> bikes;
        float totalSaleCount = 0;
        float colorPercentageSale = 0;
        for (final Bill bill : bills) {
            if (bill.getDateOfPurchase().getYear() >= year) {
                bikes = bill.getBikes();
                for (final Bike bike : bikes) {
                    if (bike.getColor().equals(color)) {
                        colorPercentageSale += bike.getPrice();
                    }
                }
                totalSaleCount += bill.getTotalPrice();
            }
        }
        final Map<String, Float> map = new HashMap<>();
        if (totalSaleCount != 0) {
            map.put("Color " + color + " percentage sale", (colorPercentageSale * 100) / totalSaleCount);
        }
        return map;
    }

}
