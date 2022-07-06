package com.spring.boot.kickstart.bicycleproject.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.spring.boot.kickstart.bicycleproject.entity.Bike;
import com.spring.boot.kickstart.bicycleproject.entity.Bill;

public interface BillService {

    Bill createNewBill(int totalPrice, List<Bike> purchasedBicycles);

    List<Bill> findAllBills();

    List<Bill> findAllOnSpecificDate(LocalDate dateOfPurchase);

    Map<String, Float> getStatistic(String brend, String color);

    Map<String, Float> getStatisticBrend(String brend);

    Map<String, Float> getStatisticColor(String color);

}
