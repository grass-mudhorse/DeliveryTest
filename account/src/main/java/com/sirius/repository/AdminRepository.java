package com.sirius.repository;

import com.sirius.entity.Admin;

public interface AdminRepository {
    public Admin login(String username, String password);
}
