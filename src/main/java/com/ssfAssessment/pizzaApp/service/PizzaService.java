package com.ssfAssessment.pizzaApp.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class PizzaService {
    
    @Autowired
    RedisTemplate<String, Object> template;

    // save order to redis
    public void saveOrder() {

    }

    // service to get order details from redis


}
