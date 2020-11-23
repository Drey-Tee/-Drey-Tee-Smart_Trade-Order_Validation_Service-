package com.soapcon.springbootwithsoap.endpoint;

import com.soapcon.springbootwithsoap.service.ValidationService;
import com.soapspringboot.springboot.GetOrderRequest;
import com.soapspringboot.springboot.GetOrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import redis.clients.jedis.Jedis;

@Endpoint
public class OrderEndpoint {
//    private GetUserResponse responses;

    @Autowired
    public ValidationService validationService; //autowiring the service create (ValidationService)

    @PayloadRoot(namespace = "http://soapspringboot.com/springboot",
    localPart = "getOrderRequest") // define namespace to retrieve the user data/ spring web service identifies
    @ResponsePayload //convert payload to soap payload type
    public GetOrderResponse getOrderRequest(@RequestPayload GetOrderRequest request) {
        System.out.println(request.getPrice());
        Jedis jedis = new Jedis();
        jedis.publish("CH2", request.getTicker());
        GetOrderResponse response = new GetOrderResponse();
        response.setOrder(ValidationService.getUsers(request.getId())); //from request, get the id
        return response;
    }
}
