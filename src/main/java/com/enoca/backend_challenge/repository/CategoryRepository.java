package com.enoca.backend_challenge.repository;

import com.enoca.backend_challenge.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("SELECT c FROM Category c WHERE c.name = :categoryName")
    Category findByName(@Param("categoryName") String categoryName);
}
