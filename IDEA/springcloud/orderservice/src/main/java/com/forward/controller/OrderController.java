package com.forward.controller;

import com.forward.pojo.Orders;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @RequestMapping("/findById/{id}")
    public Object findById(@PathVariable("id") Integer id){
        id=2;
        return new Orders(id,id,"哈哈哈哈");
    }
}
