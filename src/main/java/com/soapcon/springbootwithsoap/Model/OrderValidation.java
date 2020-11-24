package com.soapcon.springbootwithsoap.Model;

public class OrderValidation {
    public int id ;
    public String ticker;
    public double price;
    public double quantity;
    public String side;
    public double balance;

    public OrderValidation() {
    }

    public OrderValidation(int id, String ticker, double price, double quantity, String side, double balance) {
        this.id = id;
        this.ticker = ticker;
        this.price = price;
        this.quantity = quantity;
        this.side = side;
        this.balance=balance;
    }
}