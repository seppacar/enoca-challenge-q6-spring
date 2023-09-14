package com.enoca.backend_challenge.dto;

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
}
