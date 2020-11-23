package com.soapcon.springbootwithsoap.Model;

public class OrderValidation {
    public int id ;
    public String ticker;
    public double price;
    public double quantity;
    public String side;

    public OrderValidation() {
    }

    public OrderValidation(int id, String ticker, double price, double quantity, String side) {
        this.id = id;
        this.ticker = ticker;
        this.price = price;
        this.quantity = quantity;
        this.side = side;
    }
}