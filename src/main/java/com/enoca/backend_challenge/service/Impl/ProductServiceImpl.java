package com.enoca.backend_challenge.service.Impl;

import com.enoca.backend_challenge.model.Category;
import com.enoca.backend_challenge.model.Product;
import com.enoca.backend_challenge.repository.CategoryRepository;
import com.enoca.backend_challenge.repository.ProductRepository;
import com.enoca.backend_challenge.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        // Check if the product with the given id exists
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            // Map the updated fields from the provided 'updatedProduct' to the existing product entity
            Product existingProduct = optionalProduct.get();
            existingProduct.setName(product.getName());
            existingProduct.setPrice(product.getPrice());

            // Update category
            // Update the product's category if a new category name is provided
            String newCategoryName = product.getCategory().getName();
            if (newCategoryName != null) {
                Category category = categoryRepository.findByName(newCategoryName);
                if (category == null) {
                    // If the category does not exist, you can handle it as needed, e.g., create the category
                    category = new Category();
                    category.setName(newCategoryName);
                    categoryRepository.save(category);
                }
                existingProduct.setCategory(category);
            }

            // Save the updated product
            Product savedProduct = productRepository.save(existingProduct);
            return savedProduct;
        } else {
            // Product with the given id does not exist
            return null;
        }
    }

    @Override
    public boolean deleteProductById(Long id) {
        // If object exists delete and return true else return false
        if(productRepository.existsById(id)){
            productRepository.deleteById(id);
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean productExistsById(Long id) {
        return productRepository.existsById(id);
    }

}
