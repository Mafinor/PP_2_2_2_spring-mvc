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

    private static final int DEFAULT_VALUE = 5;
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public String index(@RequestParam(value = "count", required = false) Integer count, Model model) {
        if (count == null || count < 0 || count >= DEFAULT_VALUE) {
            model.addAttribute("cars", carService.getCars(DEFAULT_VALUE));
            return "/cars";
        }
        model.addAttribute("cars", carService.getCars(count));
        return "/cars";
    }
}
