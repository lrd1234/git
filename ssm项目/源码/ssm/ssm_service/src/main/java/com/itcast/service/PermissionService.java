package com.itcast.service;

import com.itcast.domain.Permission;

import java.util.List;

public interface PermissionService {
    /*查询所有资源权限*/
    List<Permission> findAll();
    /*增加一个资源权限*/
    void savePermission(Permission permission);

    List<Permission> findOtherPermission(String id);
}
