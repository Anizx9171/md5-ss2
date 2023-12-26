package com.ra.ss2.model.dao.product;

import com.ra.ss2.model.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO{
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        Session session = sessionFactory.openSession();
        try {
            System.out.println(1);
            session.beginTransaction();
            products = session.createQuery("from Product", Product.class).list();
            session.getTransaction().commit();
        }catch (Exception e) {
            System.out.println(2);
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
        return products;
    }

    @Override
    public boolean saveOrUpdate(Product product) {
        Session session = sessionFactory.openSession();
        try {
            System.out.println(1);
            session.beginTransaction();
            session.saveOrUpdate(product);
            session.getTransaction().commit();
            return true;
        }catch (Exception e) {
            System.out.println(2);
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
        return false;
    }

    @Override
    public void delete(Integer id) {
        Session session = sessionFactory.openSession();
        try {
            System.out.println(1);
            session.beginTransaction();
            session.delete(findById(id));
            session.getTransaction().commit();
        }catch (Exception e) {
            System.out.println(2);
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
    }

    @Override
    public Product findById(Integer id) {
        Product product = null;
        Session session = sessionFactory.openSession();
        try {
            System.out.println(1);
            session.beginTransaction();
            product = session.find(Product.class, id);
            session.getTransaction().commit();
        }catch (Exception e) {
            System.out.println(2);
            session.getTransaction().rollback();
        }finally {
            session.close();
        }
        return product;
    }
}
