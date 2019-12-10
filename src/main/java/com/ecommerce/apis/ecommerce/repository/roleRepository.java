package com.ecommerce.apis.ecommerce.repository;

import com.ecommerce.apis.ecommerce.entities.RoleName;
import com.ecommerce.apis.ecommerce.entities.role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface roleRepository extends JpaRepository<role, Long> {
    Optional<role> findByName(RoleName name);
}
