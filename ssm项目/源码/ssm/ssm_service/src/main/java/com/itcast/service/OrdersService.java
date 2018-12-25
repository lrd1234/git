package com.itcast.service;

import com.itcast.domain.Orders;

import java.util.List;

public interface OrdersService {
    /*查询所有的订单*/
    List<Orders> findAll(int pageStart,int pageSize);

    Orders findById(String id);
}
