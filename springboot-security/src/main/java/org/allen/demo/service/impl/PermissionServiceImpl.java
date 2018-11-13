package org.allen.demo.service.impl;

import org.allen.demo.domain.Permission;
import org.allen.demo.mapper.PermissionMapper;
import org.allen.demo.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<Permission> loadPermissionsByUserId(int userId) {
        return permissionMapper.loadPermissionsByUserId(userId);
    }
}
