package com.enoca.backend_challenge.repository;

import com.enoca.backend_challenge.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
