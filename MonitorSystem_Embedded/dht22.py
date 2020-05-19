#!/usr/bin/python
#coding=utf-8

import time
import threading
import datetime
import json
from socket import *

import Adafruit_DHT

global timer    #30S的定时器
global sendFlag #发送标志位
    
def socket_send_data(temperature,humidity,in_time):
    serverName = '101.37.77.216'
    serverPort = 12000
    clientSocket = socket(AF_INET,SOCK_STREAM)
    clientSocket.connect((serverName,serverPort))
    
    msg = {'temperature':temperature , 'humidity':humidity , 'in_time':in_time}
    json_msg = json.dumps(msg)
    clientSocket.sendall(json_msg)
    clientSocket.close()

def get_now_time():
    current_time = datetime.datetime.now()
    format_time  = datetime.datetime.strftime(current_time,'%Y-%m-%d %H:%M:%S')
    return format_time

def get_and_send_data():
    sensor = Adafruit_DHT.DHT22
    pin = 4  #GPIO4
    humidity, temperature = Adafruit_DHT.read_retry(sensor, pin , 15 , 1)
    if humidity is not None and temperature is not None:
        print('Temp={0:0.1f}*C  Humidity={1:0.1f}%'.format(temperature, humidity))
        in_time = get_now_time()
        socket_send_data(temperature,humidity,in_time)
    else:
        print('Failed to get reading. Try again!')

    global sendFlag
    sendFlag = False

#定时器
def set_timer():
    global sendFlag
    sendFlag = True
    timer = threading.Timer(5,set_timer)
    timer.start()

if __name__ == '__main__':
    global sendFlag
    sendFlag = False
    timer = threading.Timer(5,set_timer)
    timer.start()
    while(True):
        if(sendFlag):
            get_and_send_data()