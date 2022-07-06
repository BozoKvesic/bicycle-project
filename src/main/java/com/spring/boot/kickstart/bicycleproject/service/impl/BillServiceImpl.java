package com.spring.boot.kickstart.bicycleproject.service.impl;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.kickstart.bicycleproject.entity.Bike;
import com.spring.boot.kickstart.bicycleproject.entity.Bill;
import com.spring.boot.kickstart.bicycleproject.exception.BillNotFoundException;
import com.spring.boot.kickstart.bicycleproject.repository.BillRepository;
import com.spring.boot.kickstart.bicycleproject.service.BillService;
import com.spring.boot.kickstart.bicycleproject.util.DataUtil;

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
    public Map<String, Float> getStatistic(final String brand, final String color) {
        final List<Bill> bills = repository.findAll();
        final Map<String, Float> map = new HashMap<>();

        if (bills.isEmpty()) {
            throw new BillNotFoundException();
        }
        final float totalSaleCount = getTotalSaleCount(bills);
        if (totalSaleCount != 0) {
            map.put(
              "Color and brand percentage sale", (getBillCountForBrandAndColor(bills, brand, color).get(0).floatValue() * 100) / totalSaleCount);
        }
        return map;
    }

    @Override
    public Map<String, Float> getStatisticBrand(final String brand) {
        final List<Bill> bills = repository.findAll();
        final Map<String, Float> map = new HashMap<>();

        if (bills.isEmpty()) {
            throw new BillNotFoundException();
        }
        final float totalSaleCount = getTotalSaleCount(bills);
        if (totalSaleCount != 0) {
            map.put("Brand " + brand + " percentage sale", (getBillCountForBrand(bills, brand).get(0).floatValue() * 100) / totalSaleCount);
        }
        return map;
    }

    @Override
    public Map<String, Float> getStatisticColor(final String color) {
        final List<Bill> bills = repository.findAll();
        final Map<String, Float> map = new HashMap<>();

        if (bills.isEmpty()) {
            throw new BillNotFoundException();
        }
        final float totalSaleCount = getTotalSaleCount(bills);
        if (totalSaleCount != 0) {
            map.put("Color " + color + " percentage sale", (getBillCountForColor(bills, color).get(0).floatValue() * 100) / totalSaleCount);
        }
        return map;
    }

    private static List<Integer> getBillCountForBrandAndColor(final List<Bill> bills, final String brand, final String color) {
        return bills
                 .stream()
                 .filter(bill -> bill.getDateOfPurchase().getYear() >= DataUtil.getCurrentYear())
                 .map(bill -> bill
                                .getBikes()
                                .stream()
                                .filter(bike -> bike.getBrand().equals(brand) && bike.getColor().equals(color))
                                .map(Bike::getPrice)
                                .reduce(0, Integer::sum))
                 .collect(Collectors.toList());
    }

    private static List<Integer> getBillCountForColor(final List<Bill> bills, final String color) {
        return bills
                 .stream()
                 .filter(bill -> bill.getDateOfPurchase().getYear() >= DataUtil.getCurrentYear())
                 .map(bill -> bill.getBikes().stream().filter(bike -> bike.getColor().equals(color)).map(Bike::getPrice).reduce(0, Integer::sum))
                 .collect(Collectors.toList());
    }

    private static List<Integer> getBillCountForBrand(final List<Bill> bills, final String brand) {
        return bills
                 .stream()
                 .filter(bill -> bill.getDateOfPurchase().getYear() >= DataUtil.getCurrentYear())
                 .map(bill -> bill.getBikes().stream().filter(bike -> bike.getBrand().equals(brand)).map(Bike::getPrice).reduce(0, Integer::sum))
                 .collect(Collectors.toList());
    }

    private static int getTotalSaleCount(final List<Bill> bills) {
        return bills
                 .stream()
                 .filter(bill -> bill.getDateOfPurchase().getYear() >= DataUtil.getCurrentYear())
                 .map(Bill::getTotalPrice)
                 .reduce(0, Integer::sum);
    }

}
