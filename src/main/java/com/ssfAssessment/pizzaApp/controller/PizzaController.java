package com.ssfAssessment.pizzaApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PizzaController {
    
    @GetMapping(path="/")
    public String getIndex() {
        return "index";
    }

    @GetMapping(path="/pizza")
    public String orderForm() {
            // @RequestParam String pizza,
            // @RequestParam String size,
            // @RequestParam String quantity,
        // System.out.println("Pizza: " + pizza);
        // System.out.println("Size: " + size);
        // System.out.println("Quantity: " + quantity);
        return "deliveryDetails";
    }
}
