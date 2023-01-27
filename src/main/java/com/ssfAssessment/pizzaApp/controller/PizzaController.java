package com.ssfAssessment.pizzaApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PizzaController {
    

    @PostMapping(path="/pizza")
    public String orderForm(@RequestParam String pizza,
    @RequestParam String size,
    @RequestParam String quantity) {
            
        System.out.println("Pizza: " + pizza);
        System.out.println("Size: " + size);
        System.out.println("Quantity: " + quantity);
        return "deliveryDetails";
    }
}
