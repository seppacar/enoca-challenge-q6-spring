package com.enoca.backend_challenge.controller;

import com.enoca.backend_challenge.dto.CategoryDTO;
import com.enoca.backend_challenge.dto.ProductDTO;
import com.enoca.backend_challenge.model.Category;
import com.enoca.backend_challenge.service.CategoryService;
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

    // Get All Categories
    @GetMapping
    public List<CategoryDTO> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        return categories.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // TODO: Get Product with Id

    // TODO: Create Product

    // TODO: Update Product

    // TODO: Delete Product

    // Map Category to CategoryDTO
    private CategoryDTO convertToDTO(Category category) {
        List<ProductDTO> productDTOs = category.getProducts().stream()
                .map(product -> ProductDTO.builder()
                        .productId(product.getId())
                        .name(product.getName())
                        .price(product.getPrice())
                        .categoryName(product.getCategory().getName())
                        // Map other product fields if needed
                        .build())
                .collect(Collectors.toList());

        return CategoryDTO.builder()
                .categoryId(category.getId())
                .name(category.getName())
                .products(productDTOs) // Set the list of ProductDTOs
                .build();
    }
}
