package com.example.CarSales.controller;

import com.example.CarSales.repository.ColorRepository;
import com.example.CarSales.repository.MakeRepository;
import com.example.CarSales.repository.ModelRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cars")
public class CarController {

    private final MakeRepository makeRepository;
    private final ModelRepository modelRepository;
    private final ColorRepository colorRepository;

    public CarController(
            MakeRepository makeRepository,
            ModelRepository modelRepository,
            ColorRepository colorRepository
    ) {
        this.makeRepository = makeRepository;
        this.modelRepository = modelRepository;
        this.colorRepository = colorRepository;
    }

    @GetMapping("/new")
    public String showCreateCarForm(Model model) {
        model.addAttribute(
                "makes",
                makeRepository.findAllByOrderByNameAsc()
        );

        model.addAttribute(
                "colors",
                colorRepository.findAllByOrderByNameAsc()
        );

        return "cars/post-car";
    }
}
