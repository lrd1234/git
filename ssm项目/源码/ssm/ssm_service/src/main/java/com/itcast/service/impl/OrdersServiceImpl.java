package com.itcast.service.impl;

import com.github.pagehelper.PageHelper;
import com.itcast.dao.OrdersDao;
import com.itcast.domain.Orders;
import com.itcast.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersDao ordersDao;

    @Override
    public List<Orders> findAll(int pageStart,int pageSize) {
        /*第一个参数：从第几页开始，第二个参数：每页显示多少数据*/
        PageHelper.startPage(pageStart,pageSize);

        return ordersDao.findAll();
    }

    @Override
    public Orders findById(String id) {
      Orders order=  ordersDao.findById(id);
        return order;
    }
}
