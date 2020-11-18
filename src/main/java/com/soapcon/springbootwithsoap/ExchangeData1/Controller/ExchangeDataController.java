package com.soapcon.springbootwithsoap.ExchangeData1.Controller;

import com.soapcon.springbootwithsoap.ExchangeData1.Repository.ExchangeData;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@RestController
public class ExchangeDataController {

    @GetMapping("/md")
    public Flux<ExchangeData> getAllMarketData(){
        Flux<ExchangeData> marketData = WebClient.builder().baseUrl("https://exchange.matraining.com")
                .build()
                .get()
                .uri("/md/")
                .accept(MediaType.APPLICATION_JSON).retrieve()
                .bodyToFlux(ExchangeData.class);
        return marketData;
    }

    @GetMapping("/md/{TICKER}")
    public Flux<ExchangeData> getAllMarketData(@PathVariable String TICKER){
        Flux<ExchangeData> marketData = WebClient.builder().baseUrl("https://exchange.matraining.com")
                .build()
                .get()
                .uri("/md/"+TICKER)
                .accept(MediaType.APPLICATION_JSON).retrieve()
                .bodyToFlux(ExchangeData.class);
        return marketData;
    }

    @GetMapping("/data")
    public Flux<ExchangeData> getAllMarketData2(){
        Flux<ExchangeData> marketData = WebClient.builder().baseUrl("https://exchange2.matraining.com")
                .build()
                .get()
                .uri("/md/")
                .accept(MediaType.APPLICATION_JSON).retrieve()
                .bodyToFlux(ExchangeData.class);
        return marketData;
    }

    @GetMapping("/data/{TICKER}")
    public Flux<ExchangeData> getAllMarketData2(@PathVariable String TICKER){
        Flux<ExchangeData> marketData = WebClient.builder().baseUrl("https://exchange.matraining2.com")
                .build()
                .get()
                .uri("/md/"+TICKER)
                .accept(MediaType.APPLICATION_JSON).retrieve()
                .bodyToFlux(ExchangeData.class);
        return marketData;
    }
}
