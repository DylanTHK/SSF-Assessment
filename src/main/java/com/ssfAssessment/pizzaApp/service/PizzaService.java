package com.ssfAssessment.pizzaApp.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class PizzaService {
    
    @Autowired
    RedisTemplate<String, Object> template;

    // generate Order Id
    private synchronized String generateId(int numChars) {
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        while (sb.length() < numChars) {
            sb.append(Integer.toHexString(r.nextInt()));
        }
        return sb.toString().substring(0, numChars);
    }

    // calculate order cost (size, type, quantity, rush) => return total
    public Float calculateCost(String size, String type, Integer quantity, Boolean rush) {
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

    // save order to redis
    public void saveOrder() {

    }

    // service to get order details from redis


}
