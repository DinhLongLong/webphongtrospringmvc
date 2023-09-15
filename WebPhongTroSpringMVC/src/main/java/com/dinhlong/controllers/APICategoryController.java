/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dinhlong.controllers;

import com.dinhlong.pojos.Category;
import com.dinhlong.service.CategoryService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author Admin
 */
@Controller
public class APICategoryController {
    @Autowired
    private CategoryService categoryService;
    
    @CrossOrigin
    @GetMapping(path = "/api/categories", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<List<Category>> categories(Model model) {
        List<Category> listProds = this.categoryService.getCategories();
        
        return new ResponseEntity<List<Category>>(listProds, HttpStatus.OK);
    }
    
    @CrossOrigin
    @PostMapping(path = "/api/add-category", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Category> addCategory(@RequestBody Map<String, String> params) {
        String name = params.get("name");
        
        Category category = new Category();
        
        category.setName(name);
        
        Boolean isSuccess = this.categoryService.addCategory(category);
        
        if (isSuccess) {
            return new ResponseEntity<>(category, HttpStatus.OK);
        }
        
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    
    @CrossOrigin
    @PostMapping("/api/delete-category/{categoryId}")
    public ResponseEntity<Object> deleteCategory(@PathVariable int categoryId) {
        return new ResponseEntity<>(categoryService.deleteCategory(categoryId), HttpStatus.OK);
    }
    
    @CrossOrigin
    @PostMapping(path = "/api/update-category/{categoryId}", produces = {
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Category> updateCategory(@RequestBody Map<String, String> params, @PathVariable String categoryId) {
        int id = Integer.parseInt(categoryId);
        String name = params.get("name");

        Category category = new Category();

        category.setId(id);
        category.setName(name);
        Boolean isSuccess = this.categoryService.updateCategory(category);

        if (isSuccess) {
            return new ResponseEntity<>(category, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
