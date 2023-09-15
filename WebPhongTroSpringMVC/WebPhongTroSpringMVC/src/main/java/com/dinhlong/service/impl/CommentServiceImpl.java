/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dinhlong.service.impl;

import com.dinhlong.pojos.Comment;
import com.dinhlong.repository.CommentRepository;
import com.dinhlong.service.CommentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class CommentServiceImpl implements CommentService {
    
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<Comment> getCommentByProductId(int productId) {
        return this.commentRepository.getCommentByProductId(productId);
    }

    @Override
    public boolean addComment(Comment comment) {
        return commentRepository.addComment(comment);
    }
    
}
