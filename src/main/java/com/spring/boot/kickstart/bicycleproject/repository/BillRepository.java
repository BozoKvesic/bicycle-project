package com.spring.boot.kickstart.bicycleproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.kickstart.bicycleproject.entity.Bill;

public interface BillRepository extends JpaRepository<Bill, Integer> {

}
