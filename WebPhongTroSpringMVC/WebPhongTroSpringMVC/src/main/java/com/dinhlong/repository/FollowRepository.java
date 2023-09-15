/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dinhlong.repository;

import com.dinhlong.pojos.Follow;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface FollowRepository {
    boolean addFollow(Follow follow);
    List<Follow> getFollowByUserId(int userId);
}
