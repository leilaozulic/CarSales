package com.example.CarSales.DTOs;

import java.util.List;

public record CarAnalysisRequest(
        List<String> imageUrls,
        String description
) {
}