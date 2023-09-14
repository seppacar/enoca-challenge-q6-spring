package com.enoca.backend_challenge.dto;

import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
    private Long categoryId;
    private String name;
    private List<ProductDTO> products;
}
