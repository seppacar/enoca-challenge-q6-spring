package com.enoca.backend_challenge.controller;

import com.enoca.backend_challenge.dto.CategoryDTO;
import com.enoca.backend_challenge.exception.DuplicateResourceException;
import com.enoca.backend_challenge.exception.ResourceNotFoundException;
import com.enoca.backend_challenge.exception.ResourceUpdateFailedException;
import com.enoca.backend_challenge.model.Category;
import com.enoca.backend_challenge.service.CategoryService;
import com.enoca.backend_challenge.service.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("categories")
public class CategoryController {
    // Inject CategoryService
    @Autowired
    CategoryService categoryService;
    @Autowired
    CategoryMapper categoryMapper;

    // Get All Categories
    @GetMapping
    public List<CategoryDTO> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        return categories.stream()
                .map(categoryMapper::convertToDTO)
                .collect(Collectors.toList());
    }

    // Get Category by Id
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Long id) {
        Category category = categoryService.getCategoryById(id);
        if (category != null) {
            CategoryDTO categoryDTO = categoryMapper.convertToDTO(category);
            return ResponseEntity.ok(categoryDTO);
        } else {
            throw new ResourceNotFoundException("Resource with given id not found.");
        }
    }

    // Create Category
    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO) {
        Category category = categoryMapper.convertFromDTO(categoryDTO);
        Category createdCategory = categoryService.createCategory(category);
        if (createdCategory != null) {
            CategoryDTO createdCategoryDTO = categoryMapper.convertToDTO(createdCategory);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdCategoryDTO);
        } else {
            throw new DuplicateResourceException("Resource already exists.");
        }
    }

    // Update Category by Id
    @PutMapping("/{id}")
    public ResponseEntity<CategoryDTO> updateCategory(@PathVariable Long id, @RequestBody CategoryDTO categoryDTO) {
        Category updatedCategory = categoryMapper.convertFromDTO(categoryDTO);
        Category category = categoryService.updateCategory(id, updatedCategory);
        if (category != null) {
            CategoryDTO updatedCategoryDTO = categoryMapper.convertToDTO(category);
            return ResponseEntity.ok(updatedCategoryDTO);
        } else {
            throw new ResourceUpdateFailedException("Resource with given id not found or duplicate resource");
        }
    }

    // Delete Category by Id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        boolean deleted = categoryService.deleteCategoryById(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            throw new ResourceNotFoundException("Resource with given id not found.");
        }
    }

}
