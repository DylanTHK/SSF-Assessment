package com.ssfAssessment.pizzaApp.model;

import java.util.Random;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class DeliveryDetails {
    @NotNull(message="Name can not be null")
    @Size(min=3, message="Name should be between more than 3 chars")
    private String name;
    
    @NotNull(message="Address is mandatory")
    private String address;

    @Size(min=8, message="Phone number must be at least 8 digits")
    private String phone;

    // optional fields
    private Boolean rush = false;
    private String comments;


    public DeliveryDetails() {
        
    }

}
