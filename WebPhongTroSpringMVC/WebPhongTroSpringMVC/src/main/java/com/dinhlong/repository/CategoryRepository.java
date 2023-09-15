/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dinhlong.repository;

import com.dinhlong.pojos.Category;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface CategoryRepository {
    List<Category> getCategories();
    boolean updateCategory(Category category);
    boolean deleteCategory(int id);
    boolean addCategory(Category category);
    Category getCategoryById(int id);
}
