package com.vipinfirst.firstboot.controller;

import com.vipinfirst.firstboot.service.CallMSService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CallMSController {

    @Autowired
    CallMSService callMSService;

    private static final Logger FBLogger = LoggerFactory.getLogger("firstboot");

    @GetMapping("/callMsService")
    public String callToService() {
        try {
            FBLogger.info("[MS CONTROLLER] Fetching data from MS service initiated");
            return callMSService.callMicroservice();
        }catch (Exception e){
            FBLogger.error("[MS CONTROLLER] Error in Fetching data from MS service : \n", e);
        }
        return null;
    }
}
