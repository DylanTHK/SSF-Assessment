package com.ssfAssessment.pizzaApp.model;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import com.ssfAssessment.pizzaApp.service.PizzaService;

// consolidate details from DeliveryDetails and Pizza Order
public class OrderSummary {
    
    String orderId;
    
    String pizza;
    String size;
    Integer quantity;

    String name;
    String address;
    String phone;
    Boolean rush = false;
    String comments;
    Float pizzaCost;
    Float total;

    public OrderSummary() {
        this.orderId = generateId(8);
    }

    public void generateNewId() {
        this.orderId = generateId(8);
    }

    public synchronized String generateId(int numChars) {
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        while (sb.length() < numChars) {
            sb.append(Integer.toHexString(r.nextInt()));
        }
        return sb.toString().substring(0, numChars);
    }

    public void addOrder(PizzaOrder po) {
        this.pizza = po.getType();
        this.size = po.getSize();
        this.quantity = po.getQuantity();
    }

    public void addDelivery(DeliveryOrder dOrder) {
        this.name = dOrder.getName();
        this.address = dOrder.getAddress();
        this.phone = dOrder.getPhone();
        this.comments = dOrder.getComments();
        this.rush = dOrder.getRush();

        // calculate total
        this.total = calculateCost(size, pizza, quantity, rush);
    }

        // calculate order cost (size, type, quantity, rush) => return total
        public Float calculateCost(String size, String type, Integer quantity, Boolean rush) {
            Float sTotal = 0f;
            Float pizzaCost = 0f;
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
                pizzaCost = 30f;
            } else if(pizza.equals("margherita")) {
                pizzaCost = 22f;
            } else {
                pizzaCost = 25f;
            }
    
            sTotal = (pizzaCost * multiplier * quantity);
            this.pizzaCost = sTotal;
            if (rush) {
                sTotal += 2;
            }
    
            return sTotal;
        }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPizza() {
        return pizza;
    }

    public void setPizza(String pizza) {
        this.pizza = pizza;
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

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }
    

    @Override
    public String toString() {
        return "OrderSummary [orderId=" + orderId + ", pizza=" + pizza + ", size=" + size
                + ", quantity=" + quantity + ", name=" + name + ", address=" + address + ", phone=" + phone + ", rush="
                + rush + ", comments=" + comments + ", total=" + total + "]";
    }

    public Float getPizzaCost() {
        return pizzaCost;
    }

    public void setPizzaCost(Float pizzaCost) {
        this.pizzaCost = pizzaCost;
    }

    

}
