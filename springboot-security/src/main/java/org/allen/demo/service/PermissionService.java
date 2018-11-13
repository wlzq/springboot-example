package org.allen.demo.service;

import org.allen.demo.domain.Permission;

import java.util.List;

public interface PermissionService {

    List<Permission> loadPermissionsByUserId(int userId);

}
