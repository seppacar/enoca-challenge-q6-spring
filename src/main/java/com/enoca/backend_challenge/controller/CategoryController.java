package com.enoca.backend_challenge.controller;

import com.enoca.backend_challenge.dto.CategoryDTO;
import com.enoca.backend_challenge.dto.ProductDTO;
import com.enoca.backend_challenge.model.Category;
import com.enoca.backend_challenge.service.CategoryService;
import com.enoca.backend_challenge.service.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
    CategoryMapper categoryMapper

    // Get All Categories
    @GetMapping
    public List<CategoryDTO> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        return categories.stream()
                .map(categoryMapper::convertToDTO)
                .collect(Collectors.toList());
    }

    // TODO: Get Product with Id

    // TODO: Create Product

    // TODO: Update Product

    // TODO: Delete Product

}
