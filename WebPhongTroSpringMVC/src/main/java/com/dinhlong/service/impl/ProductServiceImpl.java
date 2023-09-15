/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dinhlong.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.dinhlong.DTO.ProductRequest;
import com.dinhlong.pojos.Product;
import com.dinhlong.repository.ProductRepository;
import com.dinhlong.service.ProductService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private Cloudinary cloudinary;

    @Override
    public boolean addProduct(Product product) {
        return productRepository.addProduct(product);
    }

    public List<Product> getProducts() {
        return this.productRepository.getProducts();
    }
    
    @Override
    public List<Product> getProducts(int id) {
        return this.productRepository.getProducts(id);
    }

    @Override
    public List<Product> getProductsByCategoryId(int categoryId) {
        return this.productRepository.getProductsByCategoryId(categoryId);
    }

    @Override
    public Product getProductById(int id) {
        return this.productRepository.getProductById(id);
    }

    @Override
    public boolean deleteProduct(int id) {
        return this.productRepository.deleteProduct(id);
    }

    @Override
    public boolean updateProduct(Product product) {
        return productRepository.updateProduct(product);
    }

    @Override
    public List<Product> getProductsByUserId(int userId, ProductRequest request) {
        List<Product> products = this.productRepository.getProductsByUserId(userId);
        PagedListHolder page = new PagedListHolder(products);
        page.setPageSize(request.getPageSize());
        page.setPage(request.getPageIndex());
        products = page.getPageCount() < request.getPageSize() ? page.getPageList() : new ArrayList<>();
        return products;
    }
}
