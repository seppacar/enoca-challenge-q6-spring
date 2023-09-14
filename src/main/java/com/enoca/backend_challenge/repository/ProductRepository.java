package com.enoca.backend_challenge.repository;

import com.enoca.backend_challenge.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
