package org.allen.demo.service;

import org.allen.demo.domain.User;

public interface UserService {
    User findByUsername(String username);
}
