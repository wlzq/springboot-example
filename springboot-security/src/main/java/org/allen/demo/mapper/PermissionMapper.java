package org.allen.demo.mapper;

import org.allen.demo.domain.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PermissionMapper {

    List<Permission> loadPermissionsByUserId(@Param("userId") int userId);

}
