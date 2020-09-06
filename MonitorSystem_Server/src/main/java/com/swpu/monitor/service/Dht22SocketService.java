package com.swpu.monitor.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.swpu.monitor.entity.Dht22;
import com.swpu.monitor.util.Dht22SocketUtil;
import org.springframework.context.ApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author YSXCC
 */
public class Dht22SocketService {
    public static void getInfoFromDht22(){
        System.out.println("开始接受DHT22");
        try {
            ServerSocket serverSocket = new ServerSocket(12000);
            Socket socket = serverSocket.accept();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String str;
            while ((str = bufferedReader.readLine())!=null){
                socket = serverSocket.accept();
                bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                System.out.println(str);
                JSONObject jsonObject = JSON.parseObject(str);
                Dht22 dht22 = new Dht22();
                dht22.setInTime(jsonObject.getString("in_time"));
                dht22.setTemperature(jsonObject.getString("temperature"));
                dht22.setHumidity(jsonObject.getString("humidity"));
                ApplicationContext context = Dht22SocketUtil.getApplicationContext();
                Dht22Service dht22Service = context.getBean(Dht22Service.class);
                dht22Service.addDht22Data(dht22);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }


}
