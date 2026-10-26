package com.example.CarSales.controller;

import com.example.CarSales.repository.ModelRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/makes")
public class MakeApiController {

    private final ModelRepository modelRepository;

    public MakeApiController(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @GetMapping("/{makeId}/models")
    public List<ModelOption> getModels(
            @PathVariable Integer makeId
    ) {
        return modelRepository
                .findByMake_IdOrderByNameAsc(makeId)
                .stream()
                .map(model -> new ModelOption(
                        model.getId(),
                        model.getName()
                ))
                .toList();
    }

    public record ModelOption(Integer id, String name) {
    }
}
