package com.ssfAssessment.pizzaApp.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PizzaOrder {
    
    @NotNull(message="Order must have a pizza selection")
    private String type;

    @NotBlank(message="Order must have pizza size")
    private String size;

    @NotNull(message = "Min quantity: 1")
    @Min(value = 1, message = "Min quantity: 1")
    // @Max(value = 10, message = "Max quantit: 10")
    // @Min(1)
    @Max(10)
    private Integer quantity;

    private Float total;

    public PizzaOrder() {
    }

    public PizzaOrder(String type, String size, Integer quantity) {
        this.type = type;
        this.size = size;
        this.quantity = quantity;
        this.total = calculateCost();
    }

    public Float calculateCost() {
        Float tempCost = 0f;
        Float multiplier;
        String pizza = type.toLowerCase();

        // check for pizza size
        if(size.equals("sm")) {
            multiplier = 1f;
        } else if(size.equals("md")) {
            multiplier = 1.2f;
        } else {
            multiplier = 1.5f;
        }

        // check for pizza type
        if(pizza.equals("bella") || pizza.equals("marinara") || pizza.equals("spianatacalabrese")) {
            tempCost = 30f;
        } else if(pizza.equals("margherita")) {
            tempCost = 22f;
        } else {
            tempCost = 25f;
        }
        
        return tempCost * multiplier * quantity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "PizzaOrder [type=" + type + ", size=" + size + ", quantity=" + quantity + "]";
    }

    
}
