package com.itcast.dao;

import com.itcast.domain.Permission;

import java.util.List;

public interface PermissionDao {
    Permission findPermissionByRoleId(String roleId);

    /*查询所有资源权限*/
    List<Permission> findAll();


    /*增加一个资源权限*/
    void savePermission(Permission permission);

    /*查询当前roleID下面没有的权限*/
    List<Permission> findOtherPermission(String id);
}
