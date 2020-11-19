// storing information of users
package com.soapcon.springbootwithsoap.service;

import com.soapspringboot.springboot.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class ValidationService {
    private static final Map<Integer, User> users = new HashMap<>(); // will contain list of users {key:value}

    @PostConstruct // implicitly call this method when spring boot is started/run/up
    public void initialize(){

        // user data
        User microsoft = new User();
        microsoft.setId(1100);
        microsoft.setTicker("Microsoft");
        microsoft.setSide("Buy");
        microsoft.setPrice(450.0);
        microsoft.setQuantity(40);

        users.put(microsoft.getId(), microsoft);
    }

//    get service
    public static User getUsers(int id) {
        return users.get(id);
    }
}
