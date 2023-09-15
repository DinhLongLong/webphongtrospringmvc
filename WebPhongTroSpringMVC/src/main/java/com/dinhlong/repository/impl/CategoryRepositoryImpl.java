/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dinhlong.repository.impl;

import com.dinhlong.pojos.Category;
import com.dinhlong.repository.CategoryRepository;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.HibernateException;
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
public class CategoryRepositoryImpl implements CategoryRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    @Transactional
    public List<Category> getCategories() {
        Session s = sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("From Category");
        
        return q.getResultList();
    }

    @Override
    public Category getCategoryById(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        
        return session.get(Category.class, id);
    }

    @Override
    public boolean deleteCategory(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        Category cate = this.getCategoryById(id);
        try {
            session.delete(cate);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean addCategory(Category category) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(category);
            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean updateCategory(Category category) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.update(category);
            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }
}
