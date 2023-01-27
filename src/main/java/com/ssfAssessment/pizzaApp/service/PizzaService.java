package com.ssfAssessment.pizzaApp.service;

import java.util.Random;

public class PizzaService {
    
    // generate Order Id
    private synchronized String generateId(int numChars) {
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        while (sb.length() < numChars) {
            sb.append(Integer.toHexString(r.nextInt()));
        }
        return sb.toString().substring(0, numChars);
    }

    // calculate order cost
    

    // save order to redis

}
