package com.ssfAssessment.pizzaApp.model;

import java.io.Serializable;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PizzaOrder implements Serializable{
    private static final long serialVersionUID = 1L;

    @NotNull(message="Order must have a pizza selection")
    private String type;

    @NotBlank(message="Order must have pizza size")
    private String size;

    // @NotNull(message = "Min quantity: 1")
    // @Min(value = 1, message = "Min quantity: 1")
    // @Max(value = 10, message = "Max quantit: 10")
    @Min(1)
    @Max(10)
    private Integer quantity;

    public PizzaOrder() {
    }

    public PizzaOrder(String type, String size, Integer quantity) {
        this.type = type;
        this.size = size;
        this.quantity = quantity;
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
