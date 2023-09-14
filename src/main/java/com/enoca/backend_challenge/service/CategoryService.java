package com.enoca.backend_challenge.service;

import com.enoca.backend_challenge.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();

    Category getCategoryById(Long id);

    Category createCategory(Category category);

    Category updateCategory(Long id, Category category);

    boolean deleteCategoryById(Long id);
}
