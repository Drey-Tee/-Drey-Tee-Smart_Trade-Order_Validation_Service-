package com.soapcon.springbootwithsoap.endpoint;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.soapcon.springbootwithsoap.ExchangeData.Repository.ExchangeData;
import com.soapcon.springbootwithsoap.MarketDataService.MarketDataService;
import com.soapcon.springbootwithsoap.config.OrderValidationMessagePublisher;
import com.soapcon.springbootwithsoap.order_validation.VLogic;
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

    OrderValidationMessagePublisher publisher = new OrderValidationMessagePublisher();
    @Autowired
    MarketDataService marketDataService;

    @Autowired
    public ValidationService validationService; //autowiring the service create (ValidationService)
    ExchangeData exchangeData = new ExchangeData();

    @PayloadRoot(namespace = "http://soapspringboot.com/springboot",
            localPart = "getOrderRequest") // define namespace to retrieve the user data/ spring web service identifies
    @ResponsePayload //convert payload to soap payload type
    public GetOrderResponse getOrderRequest(@RequestPayload GetOrderRequest request){
        System.out.println("" +request.getPrice());
        System.out.println(request.getTicker());
        System.out.println(request.getId());
        System.out.println(request.getBalance());
        System.out.println(request.getQuantity());
        System.out.println(request.getSide());

//        ObjectMapper objectMapper = new ObjectMapper();
//        ExchangeData exchangeData = new ExchangeData();
//        String string = "{\n" +
//                "    \"id\" : \"1100\"\n" +
//                "    \"ticker\" : \"MSFT\"\n" +
//                "    \"side\" : \"BUY\"\n" +
//                "    \"Price\" : \"50\"\n" +
//                "    \"Balance\" : \"5\"\n" +
//                "    \"Quantity\" : \"5\"\n" +
//                "}";

//        System.out.println("hello");
//        ExchangeData market = marketDataService.getExchange(request.getTicker());
//        String m = String.valueOf(market);
        System.out.println(marketDataService.getExchange(request.getTicker()));
          exchangeData = marketDataService.getExchange(request.getTicker());


//        try {
//            exchangeData = objectMapper.readValue(marketDataService.getExchange(request.getTicker()), ExchangeData.class);
//        }
//        catch (JsonMappingException e) {
//            e.printStackTrace();
//        }

        VLogic vlogic = new VLogic();

        System.out.println("Before validation");
        if (vlogic.validate(request, exchangeData)) {
            System.out.println("after validation");
        }


//        Jedis jedis = new Jedis("192.168.128.237");
//        String ticker = "md:"+request.getTicker();
//        jedis.publish("CH2", request.getTicker());
            GetOrderResponse response = new GetOrderResponse();
//        String currentMarketData = jedis.get(ticker);
            response.setOrder(ValidationService.getUsers(request.getId())); //from request, get the id
////
//        ObjectMapper objectMapper = new ObjectMapper();
//        try {
//            exchangeData = objectMapper.readValue(currentMarketData, ExchangeData.class);
//        }catch (JsonProcessingException e){
//            e.printStackTrace();
//        }
//
//
        OrderValidationMessagePublisher publisher = new OrderValidationMessagePublisher();
        String requestStr;
        requestStr = String.format("{\"id\":\"%s\",\"quantity\":%f,\"price\":%f,\"side\":\"%s\"}",
                request.getId(),request.getQuantity(),request.getPrice(),request.getSide());
//
        VLogic validationLogic = new VLogic();
        Jedis jedis = new Jedis("192.168.128.237");
        System.out.println("waiting");
        if (validationLogic.validate(request,exchangeData)){
            System.out.println("working");
            publisher.publisher("Successful");

            jedis.set(String.valueOf((request.serialize())),requestStr);
            jedis.lpush("queue:ov:te:trade_engine", String.valueOf((request.serialize())));
        }
        else{
            System.out.println("failed");
            publisher.publisher("failed");
        }
            return response;

        }
    }