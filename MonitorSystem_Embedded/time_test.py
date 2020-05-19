#!/usr/bin/python
#coding=utf-8

import datetime

cur_time = datetime.datetime.now()
nowtime = datetime.datetime.strftime(cur_time,'%Y-%m-%d %H:%M:%S')
print(nowtime)
