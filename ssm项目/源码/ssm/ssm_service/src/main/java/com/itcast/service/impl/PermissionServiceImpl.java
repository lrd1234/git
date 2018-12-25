package com.itcast.service.impl;

import com.itcast.dao.PermissionDao;
import com.itcast.domain.Permission;
import com.itcast.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PermissionServiceImpl implements PermissionService{
    @Autowired
    private PermissionDao permissionDao;
    @Override
    public List<Permission> findAll() {
        return permissionDao.findAll();
    }

    @Override
    public void savePermission(Permission permission) {
        permissionDao.savePermission(permission);
    }

    @Override
    public List<Permission> findOtherPermission(String id) {
        return permissionDao.findOtherPermission(id);
    }
}
