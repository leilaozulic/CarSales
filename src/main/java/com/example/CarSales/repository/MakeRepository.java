package com.example.CarSales.repository;

import com.example.CarSales.entity.Make;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MakeRepository
        extends JpaRepository<Make, Integer> {

    List<Make> findAllByOrderByNameAsc();
}