package com.forward.util;

import java.util.UUID;

//工具：MD5，String, 日期转换工具，配置读取，创建ID......
public class Tools {
	
	 public static String getUUID() {
		    return UUID.randomUUID().toString().replace("-","");
	 }
		
}
