///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.dinhlong.controllers;
//
//import com.dinhlong.pojos.Follow;
//import com.dinhlong.pojos.User;
//import com.dinhlong.service.FollowService;
//import com.dinhlong.service.UserService;
//import java.util.List;
//import java.util.Map;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//
///**
// *
// * @author Admin
// */
//@Controller
//public class APIFollowController {
//
//    @Autowired
//    private FollowService followService;
//
//    @Autowired
//    private UserService userService;
//
//    @CrossOrigin
//    @GetMapping(path = "/api/profile/{userId}/followers", produces = {
//        MediaType.APPLICATION_JSON_VALUE
//    })
//    public ResponseEntity<List<Follow>> followersByUserId(@PathVariable String userId) {
//        List<Follow> follows = this.followService.getFollowByUserId(Integer.parseInt(userId));
//
//        return new ResponseEntity<>(follows, HttpStatus.OK);
//    }
//
//    @CrossOrigin
//    @PostMapping(path = "/api/profile/{userId}/follow", produces = {
//        MediaType.APPLICATION_JSON_VALUE
//    })
//    public ResponseEntity<Follow> addFollow(@RequestBody Map<String, String> params, @PathVariable String userId) {
//        String userRealId = params.get("userRealId");
//
//        Follow follow = new Follow();
//
//        User user = this.userService.getUserById(Integer.parseInt(userRealId));
//        follow.setUser(user);
//
//        User follower = this.userService.getUserById(Integer.parseInt(userId));
//        follow.setFollower(follower);
//
//        Boolean isSuccess = this.followService.addFollow(follow);
//
//        if (isSuccess) {
//            return new ResponseEntity<>(follow, HttpStatus.OK);
//        }
//
//        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//    }
//}
