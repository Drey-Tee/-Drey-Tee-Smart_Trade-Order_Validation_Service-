package com.soapcon.springbootwithsoap.MarketDataService;

import com.soapcon.springbootwithsoap.ExchangeData.Controller.ExchangeDataController;
import com.soapcon.springbootwithsoap.ExchangeData.Repository.ExchangeData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarketDataService {

    @Autowired
    private ExchangeDataController exchangeData;

    public ExchangeData getExchange(String ticker){
        return this.exchangeData.getAllMarketData2(ticker);
    }
}
