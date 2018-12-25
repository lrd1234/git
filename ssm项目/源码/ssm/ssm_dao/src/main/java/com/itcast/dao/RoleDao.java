package com.itcast.dao;

import com.itcast.domain.Role;
import com.itcast.domain.Role_Permission;

import java.util.List;

public interface RoleDao {
   /*根据id查询角色信息*/
   Role findByUserId(String id);

   /*查询所有角色*/
   List<Role> findAll();

   /*新增加一个角色*/
   void saveRole(Role role);

    List<Role> findOtherRole(String id);

    Role findById(String id);

    void addPermissionToRole(Role_Permission rp);
}
