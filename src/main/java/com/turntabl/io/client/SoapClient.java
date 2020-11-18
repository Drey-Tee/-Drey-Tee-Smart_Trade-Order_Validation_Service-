package com.turntabl.io.client;

import com.turntabl.io.bindings.GetUserRequest;
import com.turntabl.io.bindings.GetUserResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

@Service
public class SoapClient {
    @Autowired
    private Jaxb2Marshaller jaxb2Marshaller;

    public GetUserResponse getItemInfo(GetUserRequest getUserRequest){
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate(jaxb2Marshaller);
        return (GetUserResponse) webServiceTemplate.marshalSendAndReceive("http://4d86be739b7e.ngrok.io/soapWS/",getUserRequest);
    }
}
