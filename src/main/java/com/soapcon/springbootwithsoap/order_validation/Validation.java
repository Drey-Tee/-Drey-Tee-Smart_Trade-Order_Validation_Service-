package com.soapcon.springbootwithsoap.order_validation;

import com.soapcon.springbootwithsoap.ExchangeData.Repository.ExchangeData;
import com.soapspringboot.springboot.GetOrderRequest;

public interface Validation {
    boolean validate(GetOrderRequest request, ExchangeData exchangeData);
}
