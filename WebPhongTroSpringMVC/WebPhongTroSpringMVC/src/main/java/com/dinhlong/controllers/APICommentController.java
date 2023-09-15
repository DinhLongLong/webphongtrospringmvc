/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dinhlong.controllers;

import com.dinhlong.pojos.Comment;
import com.dinhlong.pojos.Product;
import com.dinhlong.pojos.User;
import com.dinhlong.service.CommentService;
import com.dinhlong.service.ProductService;
import com.dinhlong.service.UserService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author Admin
 */
@Controller
public class APICommentController {
    
    @Autowired
    private CommentService commentService;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private ProductService productService;
    
    @CrossOrigin
    @GetMapping(path = "/api/product-detail/{productId}/comments", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<List<Comment>> commentsByProductId(@PathVariable String productId) {
        List<Comment> comments = this.commentService.getCommentByProductId(Integer.parseInt(productId));
        
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }
    
    @CrossOrigin
    @PostMapping(path = "/api/product-detail/add-comment", produces = {
        MediaType.APPLICATION_JSON_VALUE
    })
    public ResponseEntity<Comment> addComment(@RequestBody Map<String, String> params) {
        String userId = params.get("userId");
        String productId = params.get("productId");
        String content = params.get("content");
        
        Comment comment = new Comment();
        
        comment.setContent(content);
        
        User user = this.userService.getUserById(Integer.parseInt(userId));
        comment.setUser(user);
        
        Product product = this.productService.getProductById(Integer.parseInt(userId));
        comment.setProduct(product);
        
        Boolean isSuccess = this.commentService.addComment(comment);
        
        if (isSuccess) {
            return new ResponseEntity<>(comment, HttpStatus.OK);
        }
        
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
