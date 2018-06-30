package com.forward.controller;

import com.forward.service.IUserService;
import com.forward.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private  IUserService iUserService = new UserServiceImpl();
    @RequestMapping("/findOrderByOrderId/{orderId}")
    public Object findOrderByOrderId(@PathVariable("orderId") Integer orderId){
        return iUserService.findOrdersByOrderId(orderId);
    }
}
