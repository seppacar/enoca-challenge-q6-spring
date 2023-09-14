package com.enoca.backend_challenge.controller;

import com.enoca.backend_challenge.dto.ProductDTO;
import com.enoca.backend_challenge.model.Product;
import com.enoca.backend_challenge.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/products")
public class ProductController {
    // Inject ProductService
    @Autowired
    private ProductService productService;

    // Get All Products
    @GetMapping
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productService.getAllProducts();

        return products.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // TODO: Get Product with Id

    // TODO: Create Productss

    // TODO: Update Product

    // TODO: Delete Product

    // ProductDTO Map Method
    private ProductDTO convertToDTO(Product product) {
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
