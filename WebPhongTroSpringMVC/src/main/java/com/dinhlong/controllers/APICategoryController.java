/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dinhlong.controllers;

import com.dinhlong.pojos.Category;
import com.dinhlong.service.CategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

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
    public ResponseEntity<List<Category>> List(Model model) {
        List<Category> listProds = this.categoryService.getCategories();
        
        return new ResponseEntity<List<Category>>(listProds, HttpStatus.OK);
    }
}
