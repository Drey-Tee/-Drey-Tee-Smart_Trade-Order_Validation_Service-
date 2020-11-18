package com.turntabl.io.controller;

import com.turntabl.io.bindings.GetUserRequest;
import com.turntabl.io.bindings.GetUserResponse;
import com.turntabl.io.client.SoapClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerValidationController {
    @Autowired
    SoapClient soapClient;

    @PostMapping("/item")
    public GetUserResponse response(@RequestBody GetUserRequest getUserRequest){
        return soapClient.getItemInfo(getUserRequest);
    }
}
