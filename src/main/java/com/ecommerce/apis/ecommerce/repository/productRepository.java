package com.ecommerce.apis.ecommerce.repository;


import com.ecommerce.apis.ecommerce.entities.product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface productRepository extends JpaRepository<product, Long> {
}
