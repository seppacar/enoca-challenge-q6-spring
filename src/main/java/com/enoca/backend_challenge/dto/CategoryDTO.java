package com.enoca.backend_challenge.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_ONLY;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
    @Schema(accessMode = READ_ONLY)
    private Long categoryId;

    private String name;

    @Schema(accessMode = READ_ONLY)
    private List<ProductDTO> products;
}
