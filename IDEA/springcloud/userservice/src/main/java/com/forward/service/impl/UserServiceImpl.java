package com.forward.service.impl;

import com.forward.pojo.Orders;
import com.forward.service.IUserService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements IUserService{
    @Resource
    private RestTemplateBuilder restTemplate;
    @Override
    public Orders findOrdersByOrderId(Integer orderId) {
        RestTemplate build = restTemplate.build();
        return build.getForObject("http://localhost:8080/order/findById/"+orderId,Orders.class);
    }
}
