package com.enoca.backend_challenge.dto;

import com.enoca.backend_challenge.model.Category;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
    private Long categoryId;
    private String name;
    private List<ProductDTO> products;

    // Map Category to CategoryDTO
    public static CategoryDTO convertToDTO(Category category) {
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
