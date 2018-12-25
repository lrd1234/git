package com.itcast.service;

import com.itcast.domain.Role;

import java.util.List;

public interface RoleService {

    /*查询所有角色*/
    List<Role> findAll();

    /*新增加一个角色*/
    void saveRole(Role role);

    List<Role> findOtherRole(String id);

    Role findById(String id);

    void addPermissionToRole(String roleId, String[] ids);
}
