package com.soapcon.springbootwithsoap.ExchangeData2.Repository;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExchangeData2 {
    private final int LAST_TRADED_PRICE;
    private final double BID_PRICE;
    private final int SELL_LIMIT;
    private final String TICKER;
    private final int MAX_PRICE_SHIFT;
    private final int ASK_PRICE;
    private final int BUY_LIMIT;

    public ExchangeData2(@JsonProperty("LAST_TRADED_PRICE") int LAST_TRADED_PRICE,@JsonProperty("BID_PRICE") double BID_PRICE,@JsonProperty("SELL_LIMIT") int SELL_LIMIT,@JsonProperty("TICKER") String TICKER,@JsonProperty("MAX_PRICE_SHIFT") int MAX_PRICE_SHIFT,@JsonProperty("ASK_PRICE") int ASK_PRICE,@JsonProperty("BUY_LIMIT") int BUY_LIMIT) {
        this.LAST_TRADED_PRICE = LAST_TRADED_PRICE;
        this.BID_PRICE = BID_PRICE;
        this.SELL_LIMIT = SELL_LIMIT;
        this.TICKER = TICKER;
        this.MAX_PRICE_SHIFT = MAX_PRICE_SHIFT;
        this.ASK_PRICE = ASK_PRICE;
        this.BUY_LIMIT = BUY_LIMIT;
    }

    public int getLAST_TRADED_PRICE() {
        return LAST_TRADED_PRICE;
    }

    public double getBID_PRICE() {
        return BID_PRICE;
    }

    public int getSELL_LIMIT() {
        return SELL_LIMIT;
    }

    public String getTICKER() {
        return TICKER;
    }

    public int getMAX_PRICE_SHIFT() {
        return MAX_PRICE_SHIFT;
    }

    public int getASK_PRICE() {
        return ASK_PRICE;
    }

    public int getBUY_LIMIT() {
        return BUY_LIMIT;
    }

    @Override
    public String toString() {
        return "ExchangeData{" +
                "LAST_TRADED_PRICE=" + LAST_TRADED_PRICE +
                ", BID_PRICE=" + BID_PRICE +
                ", SELL_LIMIT=" + SELL_LIMIT +
                ", TICKER='" + TICKER + '\'' +
                ", MAX_PRICE_SHIFT=" + MAX_PRICE_SHIFT +
                ", ASK_PRICE=" + ASK_PRICE +
                ", BUY_LIMIT=" + BUY_LIMIT +
                '}';
    }
}
