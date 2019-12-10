package com.ecommerce.apis.ecommerce.repository;

import com.ecommerce.apis.ecommerce.entities.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface userRepository extends JpaRepository<user, Long> {
    Optional<user> findByEmail(String Email);

    Optional<user> findByUsernameOrEmail(String username, String email);

    Optional<user> findByUsername(String username);

    List<user> findByIdIn(List<Long> userIds);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);


}
