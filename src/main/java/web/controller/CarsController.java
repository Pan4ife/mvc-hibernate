package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarsService;

import java.util.List;

@Controller
@RequestMapping (value = "/cars")

    public class CarsController {

    private final CarsService carsService;

    public CarsController(CarsService carsService) {
        this.carsService = carsService;
    }

    @GetMapping
    public String printCars (ModelMap modelMap, @RequestParam(defaultValue = "5") int count){
        List <Car> cars = carsService.getCarsByCount(count);
        modelMap.addAttribute("cars", cars);
        return "cars";
    }
}
