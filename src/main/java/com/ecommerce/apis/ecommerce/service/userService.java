package com.ecommerce.apis.ecommerce.service;

import com.ecommerce.apis.ecommerce.entities.user;


public interface userService {
    user findByEmail(String email);

    void saveUser(user user);

}
