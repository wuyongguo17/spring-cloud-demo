package com.wyg.eurekaclient.controller;

import com.wyg.eurekaclient.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String sayHi(String message){
        return adminService.sayHello(message);
    }
}
