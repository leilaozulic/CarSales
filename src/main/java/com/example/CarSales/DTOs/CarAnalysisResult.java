package com.example.CarSales.DTOs;

public record CarAnalysisResult(
        String make,
        String model,
        Integer year,
        String bodyType,
        String exteriorColor,
        String fuelType,
        String transmission,
        String engineSize,
        Integer enginePowerHp,
        String notes
) {
}
