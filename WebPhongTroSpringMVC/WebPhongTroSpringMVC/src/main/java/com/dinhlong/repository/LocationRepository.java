/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dinhlong.repository;

import com.dinhlong.pojos.Location;
import java.util.List;

/**
 *
 * @author Admin
 */
public interface LocationRepository {
    List<Location> getLocations();
    Location getLocationById(int id);
}
