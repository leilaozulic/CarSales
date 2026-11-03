package com.example.CarSales.controller;

import com.example.CarSales.entity.CarModel;
import com.example.CarSales.repository.CarModelRepository;
import com.example.CarSales.repository.ColorRepository;
import com.example.CarSales.repository.MakeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {

    private final MakeRepository makeRepository;
    private final ColorRepository colorRepository;
    private final CarModelRepository modelRepository;

    public CarController(
            MakeRepository makeRepository,
            ColorRepository colorRepository,
            CarModelRepository modelRepository
    ) {
        this.makeRepository = makeRepository;
        this.colorRepository = colorRepository;
        this.modelRepository = modelRepository;
    }

    @GetMapping("/new")
    public String showCreateCarForm(Model model) {
        //Model model -> container for data available to Thymeleaf template
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

    @GetMapping("/models/{makeId}")
    @ResponseBody
    public List<CarModel> getModelsByMake(@PathVariable Integer makeId) {
        return modelRepository.findByMake_IdOrderByNameAsc(makeId);
    }
}
