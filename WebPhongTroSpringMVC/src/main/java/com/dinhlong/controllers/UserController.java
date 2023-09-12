/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dinhlong.controllers;

import com.dinhlong.pojos.User;
import com.dinhlong.service.UserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Admin
 */
@Controller
public class UserController {
    @Autowired
    private UserService userDetailsService;
    
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
    @GetMapping("/register")
    public String registerView(Model model) {
        model.addAttribute("user", new User());
        
        return "register";
    }
    
    @PostMapping("/register")
    public String register(Model model, @ModelAttribute(value = "user") @Valid User user,
            BindingResult result) {
        if (!result.hasErrors()) {
            String errorMessage = "";
            if (user.getPassword().equals(user.getConfirmPassword())) {
                if (userDetailsService.addUser(user) == true) {
                    return("redirect:/login");
                } else {
                    errorMessage = "Lỗi đăng ký";
                }
            } else {
                errorMessage = "Mật khẩu không trùng khớp";
            }
            model.addAttribute("errorMessage", errorMessage);  
        }       
        return "register";
    }
    
    @GetMapping("/user/post")
    public String postView(Model model) {
        return "post";
    }
}
