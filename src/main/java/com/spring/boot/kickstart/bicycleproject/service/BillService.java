package com.spring.boot.kickstart.bicycleproject.service;

import java.util.List;

import com.spring.boot.kickstart.bicycleproject.entity.Bike;
import com.spring.boot.kickstart.bicycleproject.entity.Bill;

public interface BillService {

    Bill createNewBill(int totalPrice, List<Bike> purchasedBicycles);

}