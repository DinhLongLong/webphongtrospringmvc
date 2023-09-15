/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dinhlong.fomatters;

import com.dinhlong.pojos.Product;
import org.springframework.format.Formatter;
import java.text.ParseException;
import java.util.Locale;
/**
 *
 * @author Admin
 */
public class ProductFormatter implements Formatter<Product>{
    
    @Override
    public String print(Product objectProduct, Locale locale) {
        return String.valueOf(objectProduct.getId());
    }

    @Override
    public Product parse(String productId, Locale locale) throws ParseException {
       Product prod = new Product();
       prod.setId(Integer.parseInt(productId));
       return prod;
    }

    

    
}
