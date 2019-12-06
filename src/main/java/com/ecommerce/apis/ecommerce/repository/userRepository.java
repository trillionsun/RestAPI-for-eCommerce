package com.ecommerce.apis.ecommerce.repository;

import com.ecommerce.apis.ecommerce.entities.user;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<user, Long> {
    user findByUserName(String userName);
}
