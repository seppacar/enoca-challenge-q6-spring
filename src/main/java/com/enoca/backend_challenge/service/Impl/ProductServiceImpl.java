package com.enoca.backend_challenge.service.Impl;

import com.enoca.backend_challenge.model.Category;
import com.enoca.backend_challenge.model.Product;
import com.enoca.backend_challenge.repository.ProductRepository;
import com.enoca.backend_challenge.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
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
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        // If object exists delete and return true else return false
        if(productRepository.existsById(id)){
            productRepository.deleteById(id);
            return true;
        }
        else{
            return false;
        }
    }

}
