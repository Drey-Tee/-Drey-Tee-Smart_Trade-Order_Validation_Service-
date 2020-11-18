// storing information of users
package com.soapcon.springbootwithsoap.service;

import com.soapspringboot.springboot.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class ValidationService {
    private static final Map<String, User> users = new HashMap<>(); // will contain list of users {key:value}

    @PostConstruct // implicitly call this method when spring boot is started/run/up
    public void initialize(){

        // user 2 data
        User microsoft = new User();
        microsoft.setNames("Microsoft");
        microsoft.setUserID(1100);
        microsoft.setPrice(450.0);
        microsoft.setQuantity(40);

        users.put(microsoft.getNames(), microsoft);
    }

//    get service
    public static User getUsers(String name) {
        return users.get(name);
    }
}
