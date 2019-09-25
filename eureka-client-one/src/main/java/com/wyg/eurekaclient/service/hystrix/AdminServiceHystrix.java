package com.wyg.eurekaclient.service.hystrix;

import com.wyg.eurekaclient.service.AdminService;
import org.springframework.stereotype.Component;

@Component
public class AdminServiceHystrix implements AdminService{
    @Override
    public String sayHello(String message) {
        return String.format("Hi your message is ：%s but request bad",message);
    }
}
