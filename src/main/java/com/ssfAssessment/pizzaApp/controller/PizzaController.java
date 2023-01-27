package com.ssfAssessment.pizzaApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssfAssessment.pizzaApp.model.DeliveryOrder;
import com.ssfAssessment.pizzaApp.model.OrderSummary;
import com.ssfAssessment.pizzaApp.model.PizzaOrder;
import com.ssfAssessment.pizzaApp.service.PizzaService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;

@Controller
public class PizzaController {

    @Autowired
    PizzaService pizzaSvc;
    
    // to store all order details
    OrderSummary orderSummary = new OrderSummary();

    // for index.html (view 0)
    @GetMapping(path="/")
    public String getIndex(Model model) {
        model.addAttribute("pizza", new PizzaOrder());
        return "index";
    }

    // Task2: validating order details, pass to order confirmation (view 1)
    @PostMapping(path="/pizza")
    public String orderForm(@Valid PizzaOrder pizza, BindingResult result, Model model, 
    HttpServletResponse response, @ModelAttribute("pizzaOrder") PizzaOrder pizzaOrder) {

        // validate PizzaOrder from form
        if(result.hasErrors()){
            return "index";
        }
        // set new id for new object
        orderSummary.generateNewId();

        // add information from pizza order to ordersummary
        orderSummary.addOrder(pizzaOrder);
        
        // add delivery instance for thymeleaf
        model.addAttribute("delivery", new DeliveryOrder());

        System.out.println("VIEW1 Model: " + model); // TODO REMOVE
        // response.setStatus(HttpServletResponse.SC_CREATED);
        return "deliveryDetails";
    }

    // order confirmation page (view 2)
    @PostMapping(path="/pizza/order")
    public String orderConfirmation(Model model, 
    @ModelAttribute DeliveryOrder delivery) {

        orderSummary.addDelivery(delivery);
        // calculate total cost

        System.out.println("VIEW2 model: " + model); // TODO REMOVE
        System.out.println("VIEW2 OrderSummary: " + orderSummary); // TODO REMOVE

        // T3c - call method to save summary in redis
        pizzaSvc.saveOrder(orderSummary);

        // sending orderSummary to orderConfirmation.html
        model.addAttribute("summary", orderSummary);

        return "orderConfirmation";
    }


}
