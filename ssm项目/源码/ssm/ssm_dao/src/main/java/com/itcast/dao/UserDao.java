package com.itcast.dao;

import com.itcast.domain.Role;
import com.itcast.domain.UserInfo;
import com.itcast.domain.Users_Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    /*用户登录的是时候先根据用户名查询到该用户*/
    UserInfo findByUsername(String username);


    /*查询所有用户*/
    List<UserInfo> findAll();

    /*保存用户，添加用户*/
    void saveUser(UserInfo userInfo);

    /*用户详情页，根据用户id来查找用户*/
    UserInfo findById(String id);

    /*增加一条记录到users_role表中*/
    /*加上这个注解就能够保证两个数据都能被传递过来*/
    void addRoleToUser(Users_Role ur);
}
