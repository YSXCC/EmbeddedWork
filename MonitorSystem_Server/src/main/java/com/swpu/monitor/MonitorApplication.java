package com.swpu.monitor;

import com.swpu.monitor.service.Dht22SocketService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

/**
 * @author YSXCC
 */
@SpringBootApplication
public class MonitorApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(MonitorApplication.class, args);
        Dht22SocketService.getInfoFromDht22();
    }

}
