package com.swpu.monitor.controller;

import com.swpu.monitor.entity.Dht22;
import com.swpu.monitor.service.Dht22Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author YSXCC
 */
@RestController
@RequestMapping("/dht22")
@CrossOrigin
public class DhtController {

    private final Dht22Service dht22Service;

    @Autowired
    public DhtController(Dht22Service dht22Service) {
        this.dht22Service = dht22Service;
    }

    @RequestMapping("/new-data")
    public Dht22 getNewDht22(){
        return dht22Service.getNewDht22();
    }

}
