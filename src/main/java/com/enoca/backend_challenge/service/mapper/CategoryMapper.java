package com.enoca.backend_challenge.service.mapper;

import com.enoca.backend_challenge.dto.CategoryDTO;
import com.enoca.backend_challenge.dto.ProductDTO;
import com.enoca.backend_challenge.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryMapper {

    public CategoryDTO convertToDTO(Category category){
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setCategoryId(category.getId());
        categoryDTO.setName(category.getName());
        // If Category has Products map
        if (category.getProducts() != null){
            List<ProductDTO> productDTOs = category.getProducts().stream()
                    .map(product -> ProductDTO.builder()
                            .productId(product.getId())
                            .name(product.getName())
                            .price(product.getPrice())
                            .categoryName(product.getCategory().getName())
                            // Map other product fields if needed
                            .build())
                    .collect(Collectors.toList());
            categoryDTO.setProducts(productDTOs);
        }

        return categoryDTO;
    }

    public Category convertFromDTO(CategoryDTO categoryDTO){
        Category category = new Category();
        category.setName(categoryDTO.getName());
        // Will there be other properties?
        return category;
    }

}
