/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dinhlong.controllers;

import com.dinhlong.pojos.User;
import com.dinhlong.service.CategoryService;
import com.dinhlong.service.ProductService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @Autowired
    private CategoryService categoryService;
    
    @Autowired
    private ProductService productService;
    
    @RequestMapping("/")
    public String index(Model model) {
//        model.addAttribute("categories", this.categoryService.getCategories());
//        model.addAttribute("products", this.productService.getCatProducts(1));
        
        return "index";
    }
//    public String index(Model model, 
//            @RequestParam Map<String, String> params) {
//        String location = params.get("location");
//        if (location != null) {
//            model.addAttribute("message", String.format("Location: %s", location));
//        }
//        return "index";
//    }
    
//    @RequestMapping("/{username}")
//    public String welcome(Model model, 
//            @PathVariable(value = "username") String username) {
//        model.addAttribute("message", "Xin chào " + username);
//        return "userpage";
//    }
    
    @RequestMapping("/userpage")
    public String userpage(Model model) { 
        model.addAttribute("message", "Xin chao");
        return "userpage";
    }
    
//    @RequestMapping("/login")
//    public String loginIndex(Model model) { 
//        model.addAttribute("user", new User());
//        return "login";
//    }
    
    @RequestMapping(path = "/userpage", method = RequestMethod.POST)
    public String login(Model model, @ModelAttribute(value = "user") User user) {
        model.addAttribute("message", String.format("Xin chào %s", user.getUsername()));
        return "userpage";
    }
}
