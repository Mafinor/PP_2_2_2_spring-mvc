package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;

@Controller
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public String index(@RequestParam(value = "count", required = false) String input, Model model) {
        //Для ментора - что почитать, чтобы избавится от этого ужаса с исключениями?
        //Всяко есть что-нибудь
        int count;
        try {
            count = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            model.addAttribute("cars", carService.getCars(CarService.CAR_COUNT));
            return "/cars";
        }
        if (count < 0 || count >= CarService.CAR_COUNT) {
            model.addAttribute("cars", carService.getCars(CarService.CAR_COUNT));
            return "/cars";
        }
        model.addAttribute("cars", carService.getCars(count));
        return "/cars";
    }
}
