package com.itcast.web;

import com.github.pagehelper.PageInfo;
import com.itcast.domain.Orders;
import com.itcast.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "pageStart",required =true,defaultValue = "1") Integer pageStart,@RequestParam(name = "pageSize",required =true,defaultValue = "5") Integer pageSize){
        List<Orders> orders_list = ordersService.findAll(pageStart,pageSize);
        System.out.println(orders_list);

        /*pageInfo是pageHelper中的类 作用与一个Pagebean一样*/
        PageInfo pageInfo = new PageInfo(orders_list);
        ModelAndView mav = new ModelAndView();
        mav.addObject("pageInfo",pageInfo);
        mav.setViewName("orders/orders_list");
        return mav;
    }

    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required =true) String id){
       Orders order =  ordersService.findById(id);
        ModelAndView mav = new ModelAndView();
        mav.addObject("orders",order);
        System.out.println(order);
        mav.setViewName("orders/orders-show");
        return mav;
    }
}
