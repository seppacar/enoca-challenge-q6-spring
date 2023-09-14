package com.enoca.backend_challenge.service.Impl;

import com.enoca.backend_challenge.model.Category;
import com.enoca.backend_challenge.repository.CategoryRepository;
import com.enoca.backend_challenge.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public Category getCategoryByName(String categoryName) {
        return categoryRepository.findByName(categoryName);
    }

    @Override
    public Category createCategory(Category category) {
        Category findCategory = categoryRepository.findByName(category.getName());
        if (findCategory == null){
            return categoryRepository.save(category);
        }
        else{
            return null;
        }
    }

    @Override
    public Category updateCategory(Long id, Category category) {
        // Check if the category with the given id exists in the database
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        // Check if category with same name exists
        Category findCategory = categoryRepository.findByName(category.getName());

        if (optionalCategory.isPresent() && findCategory == null) {
            Category existingCategory = optionalCategory.get();

            // Update the properties of the existing category with the provided values
            existingCategory.setName(category.getName());
            // update other properties here as needed

            // Save the updated category
            Category savedCategory = categoryRepository.save(existingCategory);

            return savedCategory;
        } else {
            // Category with the given id does not exist
            return null;
        }
    }

    @Override
    public boolean deleteCategoryById(Long id) {
        // If object exists delete and return true else return false
        if (categoryRepository.existsById(id)) {
            categoryRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean categoryExistsById(Long id) {
        return categoryExistsById(id);
    }
}
