package com.example.CarSales.repository;

import com.example.CarSales.entity.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarModelRepository
        extends JpaRepository<CarModel, Integer> {

    List<CarModel> findByMake_IdOrderByNameAsc(Integer makeId);

}