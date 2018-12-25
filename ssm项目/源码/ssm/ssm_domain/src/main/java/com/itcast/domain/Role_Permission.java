package com.itcast.domain;

public class Role_Permission {
   private String roleId;
    private String permissionId;

    public Role_Permission() {
    }

    public Role_Permission(String roleId, String permissionId) {

        this.roleId = roleId;
        this.permissionId = permissionId;
    }

    @Override
    public String toString() {
        return "Role_Permission{" +
                "roleId='" + roleId + '\'' +
                ", PermissionId='" + permissionId + '\'' +
                '}';
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }
}
