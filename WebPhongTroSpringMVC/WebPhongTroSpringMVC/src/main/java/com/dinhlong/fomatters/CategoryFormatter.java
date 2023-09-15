/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dinhlong.fomatters;

import com.dinhlong.pojos.Category;
import org.springframework.format.Formatter;
import java.text.ParseException;
import java.util.Locale;

/**
 *
 * @author nam20
 */
public class CategoryFormatter implements Formatter<Category>{

    @Override
    public String print(Category object, Locale locale) {
        return String.valueOf(object.getId());
    }

    @Override
    public Category parse(String cateId, Locale locale) throws ParseException {
       Category cate = new Category();
       cate.setId(Integer.parseInt(cateId));
       return cate;
    }
    
}
