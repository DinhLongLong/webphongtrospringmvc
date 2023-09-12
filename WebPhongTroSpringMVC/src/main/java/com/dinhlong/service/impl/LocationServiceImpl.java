/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dinhlong.service.impl;

import com.dinhlong.pojos.Location;
import com.dinhlong.repository.LocationRepository;
import com.dinhlong.service.LocationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Admin
 */
@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    private LocationRepository locationRepository;

    @Override
    public List<Location> getLocations() {
        return this.locationRepository.getLocations();
    }

    @Override
    public Location getLocationById(int id) {
         return this.locationRepository.getLocationById(id);
    }
    
}
