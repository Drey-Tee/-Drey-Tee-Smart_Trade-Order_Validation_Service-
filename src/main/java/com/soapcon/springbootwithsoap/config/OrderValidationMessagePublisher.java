package com.soapcon.springbootwithsoap.config;

import redis.clients.jedis.Jedis;

public class OrderValidationMessagePublisher {
    private final Jedis jedis = new Jedis();


    public void publisher(String message){
        this.jedis.publish("OrderValidationService", message);
    }
}
