package com.enoca.backend_challenge.controller;

import com.enoca.backend_challenge.dto.ProductDTO;
import com.enoca.backend_challenge.model.Product;
import com.enoca.backend_challenge.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
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
                .map(ProductDTO::convertToDTO)
                .collect(Collectors.toList());
    }

    // Get Product by ID
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        if (product != null) {
            ProductDTO productDTO = convertToDTO(product);
            return ResponseEntity.ok(productDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Create Product
    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
        return null;
    }

    // Update Product
    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        return null;
    }

    // Delete Product
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        boolean deleted = productService.deleteProductById(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

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
