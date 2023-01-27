package com.ssfAssessment.pizzaApp.model;

import java.io.Serializable;

// class to validate user input
public class DeliveryOrder implements Serializable{
    private static final long serialVersionUID = 1L;

    // @NotNull(message="Name can not be null")
    // @Size(min=3, message="Name should be between more than 3 chars")
    private String name;
    
    // @NotNull(message="Address is mandatory")
    private String address;

    // @Size(min=8, message="Phone number must be at least 8 digits")
    private String phone;

    // optional fields
    private Boolean rush;
    private String comments;

    // default constructor
    public DeliveryOrder() {

    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getAddress() {
        return address;
    }


    public void setAddress(String address) {
        this.address = address;
    }


    public String getPhone() {
        return phone;
    }


    public void setPhone(String phone) {
        this.phone = phone;
    }


    public Boolean getRush() {
        return rush;
    }


    public void setRush(Boolean rush) {
        this.rush = rush;
    }


    public String getComments() {
        return comments;
    }


    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "DeliveryOrder [name=" + name + ", address=" + address + ", phone=" + phone + ", rush=" + rush
                + ", comments=" + comments + "]";
    }


}
