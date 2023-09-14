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
