package com.itcast.dao;

import com.itcast.domain.Traveller;

public interface TravellerDao {
    /*根据旅客id来查询旅客信息*/
    Traveller findById(String id);
}
