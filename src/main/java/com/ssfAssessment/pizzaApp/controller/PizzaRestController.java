package com.ssfAssessment.pizzaApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ssfAssessment.pizzaApp.service.PizzaService;

@RestController
public class PizzaRestController {
    
    @Autowired
    PizzaService pizzaSvc;

    @Autowired
    RedisTemplate<String, Object> template;
    
    @GetMapping(path="/order/{id}")
    public ResponseEntity<String> getJsonOrder(@PathVariable(value="id") String id) {

        // use id to get value from redis
        String jsonOrder = template.opsForValue().get(id).toString();

        return ResponseEntity
            .status(HttpStatus.OK)
            .contentType(MediaType.APPLICATION_JSON)
            .body(jsonOrder);
    }
}
