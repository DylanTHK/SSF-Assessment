package com.ssfAssessment.pizzaApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssfAssessment.pizzaApp.model.OrderSummary;

@Service
public class PizzaService {
    
    @Autowired
    RedisTemplate<String, Object> template;

    // save order to redis
    public void saveOrder(OrderSummary os) {

        // extract orderId for key
        String key = os.getOrderId();

        // convert object to json
        ObjectMapper mapper = new ObjectMapper();
        try {
            String json = mapper.writeValueAsString(os);
            System.out.println("ResultingJSONstring = " + json);
            template.opsForValue().set(key, json);
            
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


    }

    // service to get order details from redis


}
