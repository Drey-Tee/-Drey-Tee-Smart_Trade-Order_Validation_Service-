package com.soapcon.springbootwithsoap.order_validation;

import com.soapspringboot.springboot.GetOrderRequest;

public class ValidationStatus{
    private String status;
    private GetOrderRequest orderRequest;

    public ValidationStatus(String status) {
        this.status = status;
    }

    public ValidationStatus(GetOrderRequest orderRequest,String status) {
        this.status = status;
        this.orderRequest = orderRequest;
    }

    public GetOrderRequest getOrderRequest() {
        return orderRequest;
    }

    public void setOrderRequest(GetOrderRequest orderRequest) {
        this.orderRequest = orderRequest;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
