package com.example.CarSales.DTOs;

import java.math.BigDecimal;

public record CreateListingRequest(
        String make,
        String model,
        Integer year,
        String bodyType,
        String exteriorColor,
        Integer mileage,
        String fuelType,
        String transmission,
        String engineSize,
        Integer enginePowerHp,
        String vin,
        BigDecimal price,
        String listingDescription,
        String aiNotes
) {
}
