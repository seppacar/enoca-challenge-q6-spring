package com.enoca.backend_challenge.service.mapper;

import com.enoca.backend_challenge.dto.ProductDTO;
import com.enoca.backend_challenge.model.Category;
import com.enoca.backend_challenge.model.Product;
import com.enoca.backend_challenge.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {
    @Autowired
    private CategoryRepository categoryRepository;
    public ProductDTO convertToDTO(Product product) {
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

    public Product convertFromDTO(ProductDTO productDTO, boolean createCategoryIfNotExists){
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());

        // Set the Category based on the categoryName from the request
        String categoryName = productDTO.getCategoryName();
        if (categoryName != null) {
            Category category = categoryRepository.findByName(categoryName);
            if (category == null && createCategoryIfNotExists) {
                // If the category does not exist, you can handle it as needed, e.g., create the category
                category = new Category();
                category.setName(categoryName);
                categoryRepository.save(category);
            }
            product.setCategory(category);
        }

        return product;
    }
}
