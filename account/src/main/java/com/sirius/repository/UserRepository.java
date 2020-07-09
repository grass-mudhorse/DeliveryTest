package com.sirius.repository;

import com.sirius.entity.User;

public interface UserRepository {
    public User login(String username, String password);
}
