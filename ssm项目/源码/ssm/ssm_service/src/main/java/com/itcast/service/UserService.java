package com.itcast.service;

import com.itcast.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface UserService extends UserDetailsService{

    /*查询所有用户*/
    List<UserInfo> findAll();

    /*保存用户，添加用户*/
    void saveUser(UserInfo userInfo);

    /*用户详情页，根据用户id来查找用户*/
    UserInfo findById(String id);

    void addRoleToUser(String userId, String[] ids);
}
