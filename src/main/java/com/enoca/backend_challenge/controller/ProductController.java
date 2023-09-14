package com.enoca.backend_challenge.controller;

import com.enoca.backend_challenge.dto.ProductDTO;
import com.enoca.backend_challenge.model.Product;
import com.enoca.backend_challenge.service.ProductService;
import com.enoca.backend_challenge.service.mapper.ProductMapper;
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
    @Autowired
    private ProductMapper productMapper;

    // Get All Products
    @GetMapping
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productService.getAllProducts();

        return products.stream()
                .map(productMapper::convertToDTO)
                .collect(Collectors.toList());
    }

    // Get Product by ID
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        if (product != null) {
            ProductDTO productDTO = productMapper.convertToDTO(product);
            return ResponseEntity.ok(productDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Create Product
    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO) {
        // Create Product from ProductDTO
        Product newProduct = productMapper.convertFromDTO(productDTO, true);
        // Insert Product to db
        Product createdProduct = productService.createProduct(newProduct);
        // Convert inserted Product to ProductDTO
        ProductDTO createdProductDTO = productMapper.convertToDTO(createdProduct);
        // Response
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProductDTO);
    }

    // Update Product
    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        if (productService.productExistsById(id)){
            // Map Request Body "ProductDTO" to "Product" model
            Product productToUpdate = productMapper.convertFromDTO(productDTO, true);
            // Update
            Product updatedProduct = productService.updateProduct(id, productToUpdate);
            // Check if updated
            if (updatedProduct != null) {
                ProductDTO updatedProductDTO = productMapper.convertToDTO(updatedProduct);
                return ResponseEntity.ok(updatedProductDTO);
            } else {
                return ResponseEntity.notFound().build();
            }
        }
        else{
            return ResponseEntity.notFound().build();
        }
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
}
