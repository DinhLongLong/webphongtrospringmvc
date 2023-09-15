/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dinhlong.controllers;

import com.dinhlong.DTO.ProductRequest;
import com.dinhlong.pojos.Category;
import com.dinhlong.pojos.Location;
import com.dinhlong.pojos.Product;
import com.dinhlong.pojos.User;
import com.dinhlong.service.CategoryService;
import com.dinhlong.service.LocationService;
import com.dinhlong.service.ProductService;
import com.dinhlong.service.UserService;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Admin
 */
@Controller
public class APIProductController {
    
    @Autowired
    private ProductService productService;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private CategoryService categoryService;
    
    @Autowired
    private LocationService locationService;
    
    @CrossOrigin
    @GetMapping(path = "/api/products", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<List<Product>> products(Model model) {
        List<Product> products = this.productService.getProducts();
        
        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
    }
    
    @CrossOrigin
    @GetMapping(path = "/api/category/{categoryId}/products", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<List<Product>> productsByCategoryId(@PathVariable String categoryId) {
        List<Product> products = this.productService.getProductsByCategoryId(Integer.parseInt(categoryId));
        
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    
    @CrossOrigin
    @GetMapping(path = "/api/user/{userId}/products", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<List<Product>> productsByUserId(@PathVariable String userId, @RequestBody ProductRequest request) {
        List<Product> products = this.productService.getProductsByUserId(Integer.parseInt(userId), request);
        
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    
    @CrossOrigin
    @GetMapping(path = "/api/product-detail/{productId}", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<List<Product>> productDetail(@PathVariable String productId) {
        List<Product> product = this.productService.getProducts(Integer.parseInt(productId));
        
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    
    @CrossOrigin
    @PostMapping(path = "/api/add-product", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Product> addProduct(@RequestBody Map<String, String> params) {
        String name = params.get("name");
        String price = params.get("price");
        String description = params.get("description");
        String userId = params.get("userId");
        String acreage = params.get("acreage");
        String locationId = params.get("locationId");
        String categoryId = params.get("categoryId");
        String img = params.get("img");
        
        Product prod = new Product();
        
        prod.setAcreage(Double.parseDouble(acreage));
        prod.setImg(img);
        prod.setDescription(description);
        prod.setPrice(new BigDecimal(price));
        prod.setName(name);
        
        User user = this.userService.getUserById(Integer.parseInt(userId));
        prod.setUser(user);
        
        Category category = this.categoryService.getCategoryById(Integer.parseInt(categoryId));
        prod.setCategory(category);
        
        Location location = this.locationService.getLocationById(Integer.parseInt(locationId));
        prod.setLocation(location);
        
        Boolean isSuccess = this.productService.addProduct(prod);
        
        if (isSuccess) {
            return new ResponseEntity<>(prod, HttpStatus.OK);
        }
        
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    
    @CrossOrigin
    @PostMapping("/api/delete-product/{productId}")
    public ResponseEntity<Object> deleteProduct(@PathVariable int productId) {
        return new ResponseEntity<>(productService.deleteProduct(productId), HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(path = "/api/update-product", produces = {
            MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Product> updateProduct(@RequestBody Map<String, String> params) {
        int id = Integer.valueOf(params.get("id"));
        String name = params.get("name");
        String price = params.get("price");
        String description = params.get("description");
        String userId = params.get("userId");
        String acreage = params.get("acreage");
        String locationId = params.get("locationId");
        String categoryId = params.get("categoryId");
        String img = params.get("img");

        Product prod = new Product();

        prod.setId(id);
        prod.setAcreage(Double.parseDouble(acreage));
        prod.setImg(img);
        prod.setDescription(description);
        prod.setPrice(new BigDecimal(price));
        prod.setName(name);

        prod.setUser(Objects.nonNull(userId) ? this.userService.getUserById(Integer.parseInt(userId)) : null);
        prod.setCategory(Objects.nonNull(categoryId) ? this.categoryService.getCategoryById(Integer.parseInt(categoryId)) : null);
        prod.setLocation(Objects.nonNull(locationId) ? this.locationService.getLocationById(Integer.parseInt(locationId)) : null);

        Boolean isSuccess = this.productService.updateProduct(prod);

        if (isSuccess) {
            return new ResponseEntity<>(prod, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
