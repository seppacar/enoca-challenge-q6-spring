package com.enoca.backend_challenge.dto;

import com.enoca.backend_challenge.model.Product;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Long productId;
    private String name;
    private double price;
    private String categoryName;

    public static ProductDTO convertToDTO(Product product) {
        ProductDTO productDTO = ProductDTO.builder()
                .productId(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .build();

        if (product.getCategory() != null) {
            productDTO.setCategoryName(product.getCategory().getName());
        }

        return productDTO;
    }

}
