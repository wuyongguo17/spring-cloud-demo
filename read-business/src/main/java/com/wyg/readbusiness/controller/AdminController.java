package com.wyg.readbusiness.controller;

import com.wyg.readbusiness.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//必须为@RestController注解
@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String sayHi(String message){
        return adminService.sayHi(message);
    }
}
