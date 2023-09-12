/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dinhlong.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.dinhlong.pojos.Product;
import com.dinhlong.repository.ProductRepository;
import com.dinhlong.service.ProductService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Product> getCatProducts(int categoryId) {
        return this.productRepository.getCatProducts(categoryId);
    }

    @Override
    public Product getProductById(int id) {
        return this.productRepository.getProductById(id);
    }

    @Override
    public boolean deleteProduct(int id) {
        return this.productRepository.deleteProduct(id);
    }
}
