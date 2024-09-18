package com.vipinfirst.firstboot.service.impl;

import com.vipinfirst.firstboot.service.CallMSService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CallMSServiceImpl extends CallMSService {
    private final RestTemplate restTemplate;

    private static final Logger FBLogger = LoggerFactory.getLogger("firstboot");

    @Autowired
    public CallMSServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public String callMicroservice() {
        try{
            String microserviceUrl = "http://localhost:3000/about";
            FBLogger.info("[CallMSServiceImpl] Fetching data from url : {}", microserviceUrl);
            return restTemplate.getForObject(microserviceUrl, String.class);
        }catch (Exception e){
            FBLogger.error("[CallMSServiceImpl] Error in Fetching data from MS service : \n", e);
        }
       return "Error in Fetching data from MS service";
    }
}
