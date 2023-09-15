/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dinhlong.repository.impl;

import com.dinhlong.pojos.Location;
import com.dinhlong.pojos.User;
import com.dinhlong.repository.LocationRepository;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Admin
 */
@Repository
@Transactional
public class LocationRepositoryImpl implements LocationRepository {
    
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Location> getLocations() {
        Session s = sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("From Location");
        
        return q.getResultList();
    }

    @Override
    public Location getLocationById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        return session.get(Location.class, id);
    }
}
