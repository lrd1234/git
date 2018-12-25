package com.itcast.service.impl;

import com.itcast.dao.RoleDao;
import com.itcast.domain.Role;
import com.itcast.domain.Role_Permission;
import com.itcast.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RoleDao roleDao;
    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    public void saveRole(Role role) {
        roleDao.saveRole(role);
    }

    @Override
    public List<Role> findOtherRole(String id) {
        return roleDao.findOtherRole(id);
    }

    @Override
    public Role findById(String id) {
        return roleDao.findById(id);
    }

    @Override
    public void addPermissionToRole(String roleId, String[] ids) {

        for (String permissionId : ids) {
            Role_Permission rp = new Role_Permission();
            rp.setRoleId(roleId);
            rp.setPermissionId(permissionId);
            roleDao.addPermissionToRole(rp);
        }
    }
}
