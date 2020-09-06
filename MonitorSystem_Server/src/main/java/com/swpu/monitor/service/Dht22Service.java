package com.swpu.monitor.service;

import com.swpu.monitor.entity.Dht22;
import com.swpu.monitor.mapper.Dht22Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author YSXCC
 */
@Service
public class Dht22Service {

    private final Dht22Mapper dht22Mapper;

    @Autowired
    public Dht22Service(Dht22Mapper dht22Mapper) {
        this.dht22Mapper = dht22Mapper;
    }

    public Dht22 getNewDht22(){
        return dht22Mapper.getNewDht22();
    }

    public int addDht22Data(Dht22 dht22){
        return dht22Mapper.addDht22Data(dht22.getInTime(),dht22.getTemperature(),dht22.getHumidity());
    }

}
