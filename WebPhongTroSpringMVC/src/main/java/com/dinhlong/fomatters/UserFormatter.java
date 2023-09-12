/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dinhlong.fomatters;

import com.dinhlong.pojos.Category;
import com.dinhlong.pojos.User;
import org.springframework.format.Formatter;
import java.text.ParseException;
import java.util.Locale;
/**
 *
 * @author Admin
 */
public class UserFormatter implements Formatter<User> {

    @Override
    public String print(User object, Locale locale) {
        return String.valueOf(object.getId());
    }

    @Override
    public User parse(String userId, Locale locale) throws ParseException {
        User user = new User();
       user.setId(Integer.parseInt(userId));
       return user;
    }
    
}
