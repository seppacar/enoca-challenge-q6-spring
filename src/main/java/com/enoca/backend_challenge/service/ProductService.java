package com.enoca.backend_challenge.service;

import com.enoca.backend_challenge.model.Category;
import com.enoca.backend_challenge.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product getProductById(Long id);

    Product createProduct(Product product);

    Product updateProduct(Long id, Product product);

    boolean deleteById(Long id);
}
