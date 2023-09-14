package com.enoca.backend_challenge.dto;

import com.enoca.backend_challenge.model.Product;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_ONLY;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    @Schema(accessMode = READ_ONLY)
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
