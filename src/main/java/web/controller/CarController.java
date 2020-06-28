package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import web.model.Car;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {
//    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    protected CarService carService;

    @GetMapping(value = "/car")
    public String printCars(ModelMap model) {
        List<String> messages = new ArrayList<>();

        for (Car car : carService.getAllCars()) {
            messages.add(car.getName());
        }
        model.addAttribute("messages", messages);
        return "cars";
    }
}