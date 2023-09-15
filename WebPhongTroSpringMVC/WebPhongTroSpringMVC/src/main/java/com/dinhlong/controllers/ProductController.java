/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dinhlong.controllers;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.dinhlong.pojos.Category;
import com.dinhlong.pojos.Location;
import com.dinhlong.pojos.Product;
import com.dinhlong.service.CategoryService;
import com.dinhlong.service.LocationService;
import com.dinhlong.service.ProductService;
import java.io.IOException;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Admin
 */
@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private LocationService locationService;

//    @CrossOrigin(origins = "http://192.168.43.195:3000")
//    @GetMapping(path = "/api/get-product", produces = {
//        MediaType.APPLICATION_JSON_VALUE
//    })
//    public ResponseEntity<String> List(Model model) {
////        model.addAttribute("product", new Product());
////        model.addAttribute("categories", this.categoryService.getCategories());
////        model.addAttribute("locations", this.locationService.getLocations());
////        
////        return "productManager";
//        
//
//        return ResponseEntity.ok("Response from api java test");
//    }

    @PostMapping("/admin/products")
    public String add(Model model, @ModelAttribute(value = "product") Product product) {
        String errorMessage = "";
        if (productService.addProduct(product) == true) {
            return "redirect:/";
        } else {
            errorMessage = "Lỗi thêm sản phẩm";
        }
        model.addAttribute("errorMassage", errorMessage);
        return "productManager";
//        try {
//            Map r = this.cloudinary.uploader().upload(product.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
//            String img = (String) r.get("secure_url");
//            return "redirect:/";
//        } catch (IOException e) {
//            System.err.println("ADD PRODUCT FAIL");
//        }
//        return "productManager";
    }
}
