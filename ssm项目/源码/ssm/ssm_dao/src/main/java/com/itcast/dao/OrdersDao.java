package com.itcast.dao;


import com.itcast.domain.Orders;

import java.util.List;

public interface OrdersDao {
    /*查询所有订单*/
    List<Orders> findAll();

    Orders findById(String id);
}
