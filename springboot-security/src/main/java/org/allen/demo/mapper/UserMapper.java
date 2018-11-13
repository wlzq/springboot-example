package org.allen.demo.mapper;

import org.allen.demo.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User findByUsername(String username);
}
