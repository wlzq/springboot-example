package org.allen.demo.domain;

public class RolePermission {

    private int rolePermId;
    private int roleId;
    private int permId;

    public int getRolePermId() {
        return rolePermId;
    }

    public void setRolePermId(int rolePermId) {
        this.rolePermId = rolePermId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getPermId() {
        return permId;
    }

    public void setPermId(int permId) {
        this.permId = permId;
    }
}
