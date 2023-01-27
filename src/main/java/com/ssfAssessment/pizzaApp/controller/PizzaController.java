package com.ssfAssessment.pizzaApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssfAssessment.pizzaApp.model.DeliveryOrder;
import com.ssfAssessment.pizzaApp.model.PizzaOrder;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@Controller
public class PizzaController {
    
    // for index.html (view 0)
    @GetMapping(path="/")
    public String getIndex(Model model) {
        model.addAttribute("pizza", new PizzaOrder());
        return "index";
    }

    // Task2: validating order details, pass to order confirmation (view 1)
    @PostMapping(path="/pizza")
    public String orderForm(@Valid PizzaOrder pizza, BindingResult result, Model model, 
    HttpServletResponse response, @ModelAttribute PizzaOrder pizzaOrder) {

        if(result.hasErrors()){
            return "index";
        }

        DeliveryOrder dOrder = new DeliveryOrder(pizzaOrder);
        model.addAttribute("delivery", dOrder);
        System.out.println("In orderForm Model: " + model); // TODO REMOVE
        // response.setStatus(HttpServletResponse.SC_CREATED);
        return "deliveryDetails";
    }

    // order confirmation page (view 2)
    @PostMapping(path="/pizza/order")
    public String orderConfirmation(@ModelAttribute PizzaOrder pizza,
        @ModelAttribute DeliveryOrder delivery) {

        System.out.println("In orderConfirmation Model: " + pizza); // TODO REMOVE

        System.out.println("In orderConfirmation Model: " + delivery); // TODO REMOVE

        return "orderConfirmation";
    }


}
