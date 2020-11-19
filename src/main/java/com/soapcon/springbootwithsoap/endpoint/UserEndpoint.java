package com.soapcon.springbootwithsoap.endpoint;

import com.soapcon.springbootwithsoap.service.ValidationService;
import com.soapspringboot.springboot.GetUserRequest;
import com.soapspringboot.springboot.GetUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;
import java.util.List;

@Endpoint
public class UserEndpoint {
//    private GetUserResponse responses;

    @Autowired
    public ValidationService validationService; //autowiring the service create (ValidationService)

    @PayloadRoot(namespace = "http://soapspringboot.com/springboot",
    localPart = "getUserRequest") // define namespace to retrieve the user data/ spring web service identifies
    @ResponsePayload //convert payload to soap payload type
    public GetUserResponse getUserRequest(@RequestPayload GetUserRequest request){
        GetUserResponse response = new GetUserResponse();
        response.setUser(validationService.getUsers(request.getId())); //from request, get the id

        List<String> message = new ArrayList<>();
        message.add("Success");
        message.add("Fail");

        if (request.getId() == response.getUser().getId()){
            System.out.println("Connect successfully");
        }
        else {
            System.out.println("Failed to connect");
        }
        return null;

    }
}
