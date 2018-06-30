package com.forward.service;

import com.forward.pojo.Orders;

public interface IUserService {
    Orders findOrdersByOrderId(Integer orderId);
}
