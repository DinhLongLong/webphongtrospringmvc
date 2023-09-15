/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dinhlong.repository;

import com.dinhlong.pojos.Product;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface ProductRepository {
    boolean addProduct(Product product);
    boolean deleteProduct(int id);
    boolean updateProduct(Product product);
    Product getProductById(int id);
    List<Product> getProducts();
    List<Product> getProducts(int id);
    List<Product> getProductsByUserId(int userId);
    List<Product> getProductsByCategoryId(int categoryId);
}
