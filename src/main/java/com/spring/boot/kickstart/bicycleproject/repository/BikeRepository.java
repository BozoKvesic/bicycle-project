package com.spring.boot.kickstart.bicycleproject.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.boot.kickstart.bicycleproject.entity.Bike;

public interface BikeRepository extends JpaRepository<Bike, Integer> {

    List<Bike> findAllByBrand(String brand);

}