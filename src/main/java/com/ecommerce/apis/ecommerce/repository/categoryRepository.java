package com.ecommerce.apis.ecommerce.repository;

import com.ecommerce.apis.ecommerce.entities.category;
import com.ecommerce.apis.ecommerce.entities.categoryName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface categoryRepository extends JpaRepository<category, Long> {
    boolean existsByName(categoryName name);

    Optional<category> findByName(categoryName name);
}
