package com.example.CarSales.repository;

import com.example.CarSales.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModelRepository
        extends JpaRepository<Model, Integer> {

    List<Model> findByMake_IdOrderByNameAsc(Integer makeId);
}