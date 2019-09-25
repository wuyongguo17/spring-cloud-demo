package com.wyg.readbusiness.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Value("${server.port}")
    private String port;

    public String sayHi(String message){
        return String.format("%s 发送请求，当前端口：%s",message,port);
    }
}
