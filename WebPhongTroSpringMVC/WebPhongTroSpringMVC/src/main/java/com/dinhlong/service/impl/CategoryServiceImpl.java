/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dinhlong.service.impl;

import com.dinhlong.pojos.Category;
import com.dinhlong.repository.CategoryRepository;
import com.dinhlong.service.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getCategories() {
        return this.categoryRepository.getCategories();
    }

    @Override
    public Category getCategoryById(int id) {
         return this.categoryRepository.getCategoryById(id);
    }

    @Override
    public boolean deleteCategory(int id) {
        return this.categoryRepository.deleteCategory(id);
    }

    @Override
    public boolean addCategory(Category category) {
        return categoryRepository.addCategory(category);
    }

    @Override
    public boolean updateCategory(Category category) {
        return this.categoryRepository.updateCategory(category);
    }
}
