package com.ssfAssessment.pizzaApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssfAssessment.pizzaApp.model.DeliveryDetails;
import com.ssfAssessment.pizzaApp.model.PizzaOrder;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@Controller
public class PizzaController {
    
    // for index.html
    @GetMapping(path="/")
    public String getIndex(Model model) {
        model.addAttribute("pizza", new PizzaOrder());
        return "index";
    }

    // obtaining order details
    @PostMapping(path="/pizza")
    public String orderForm(@Valid PizzaOrder pizza, BindingResult result, Model model, HttpServletResponse response) {
        if(result.hasErrors()){
            return "index";
        }
        model.addAttribute("delivery", new DeliveryDetails());
        System.out.println("Model: " + model);
        // response.setStatus(HttpServletResponse.SC_CREATED);
        return "deliveryDetails";
    }


}
