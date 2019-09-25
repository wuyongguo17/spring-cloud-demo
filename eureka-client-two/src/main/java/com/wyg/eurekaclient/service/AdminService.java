package com.wyg.eurekaclient.service;

import com.wyg.eurekaclient.service.hystrix.AdminServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//value = "read-business"是服务提供者的yml配置文件中的spring.application.name的值
//feign会自动实现负载均衡
@FeignClient(value = "read-business",fallback = AdminServiceHystrix.class)
public interface AdminService {
    //注意：必须指定@RequestParam的参数的名字，保证与服务提供者的参数名保持一致
    //@RequestMapping的value的值必须与服务提供者的value相同
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String sayHello(@RequestParam("message") String message);
}
