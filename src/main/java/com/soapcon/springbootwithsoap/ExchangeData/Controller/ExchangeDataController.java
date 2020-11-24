package com.soapcon.springbootwithsoap.ExchangeData.Controller;

import com.soapcon.springbootwithsoap.ExchangeData.Repository.ExchangeData;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class ExchangeDataController {

    public Flux<ExchangeData> getAllMarketData(){
        Flux<ExchangeData> marketData = WebClient.builder().baseUrl("https://exchange2.matraining.com")
                .build()
                .get()
                .uri("/md/")
                .accept(MediaType.APPLICATION_JSON).retrieve()
                .bodyToFlux(ExchangeData.class);
        return marketData;
    }

    public Flux<ExchangeData> getAllMarketData(String TICKER){
        Flux<ExchangeData> marketData = WebClient.builder().baseUrl("https://exchange2.matraining.com")
                .build()
                .get()
                .uri("/md/"+TICKER)
                .accept(MediaType.APPLICATION_JSON).retrieve()
                .bodyToFlux(ExchangeData.class);
        return marketData;
    }

    public Flux<ExchangeData> getAllMarketData2(){
        Flux<ExchangeData> marketData = WebClient.builder().baseUrl("https://exchange.matraining.com")
                .build()
                .get()
                .uri("/md/")
                .accept(MediaType.APPLICATION_JSON).retrieve()
                .bodyToFlux(ExchangeData.class);
        return marketData;
    }

    public ExchangeData getAllMarketData2(String TICKER){
        ExchangeData marketData = WebClient.builder().baseUrl("https://exchange.matraining.com")
                .build()
                .get()
                .uri("/md/"+TICKER)
                .retrieve()
                .bodyToMono(ExchangeData.class)
                .block();
        return marketData;
    }
    String response = getAllMarketData2().toString();
}
