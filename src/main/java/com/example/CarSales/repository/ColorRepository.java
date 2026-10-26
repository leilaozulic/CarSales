package com.example.CarSales.repository;

import com.example.CarSales.entity.Color;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ColorRepository extends JpaRepository<Color, Integer> {

    List<Color> findAllByOrderByNameAsc();
}
