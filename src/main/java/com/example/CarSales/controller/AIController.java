package com.example.CarSales.controller;

import com.example.CarSales.DTOs.CarAnalysisRequest;
import com.example.CarSales.DTOs.CarAnalysisResult;
import com.example.CarSales.service.OpenAIService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ai")
public class AIController {

    private final OpenAIService openAIService;

    public AIController(OpenAIService openAIService) {
        this.openAIService = openAIService;
    }

    @PostMapping("/analyse-car")
    public CarAnalysisResult analyseCar(
            @RequestBody CarAnalysisRequest request
    ) {
        return openAIService.analyseCarPhoto(
                request.imageUrls(),
                request.description()
        );
    }
}
