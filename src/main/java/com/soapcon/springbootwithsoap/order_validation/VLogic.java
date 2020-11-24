package com.soapcon.springbootwithsoap.order_validation;

import com.soapcon.springbootwithsoap.ExchangeData.Repository.ExchangeData;
import com.soapcon.springbootwithsoap.config.OrderValidationMessagePublisher;
import com.soapspringboot.springboot.GetOrderRequest;

public class VLogic implements Validation {

    OrderValidationMessagePublisher publisher = new OrderValidationMessagePublisher();
    String logs[] = {"Quantity can not be null",
            "Quantity requested is more than is available",
            "Balance is insufficient"};

    @Override
    public boolean validate(GetOrderRequest request, ExchangeData exchangeData) {
        double orderPurchase=request.getPrice()*request.getQuantity();

//        Check customer quantity
        if(request.getSide().equals("BUY")||request.getSide().equals("SELL")){
            if(request.getQuantity()<=0){
                publisher.publisher(logs[0]);
                return false;
            }else if(request.getQuantity()>exchangeData.getBUY_LIMIT()){
                publisher.publisher(logs[1]);
                return false;
//                check customer price
            }
            else if(request.getQuantity()>exchangeData.getSELL_LIMIT()) {
                publisher.publisher(logs[1]);
                return false;
            }else if(orderPurchase < request.getBalance()){
                publisher.publisher(logs[2]);
                return false;
            }
        }
        return true;
    }
}