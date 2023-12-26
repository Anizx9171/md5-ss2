package com.ra.ss2.model.dao.category;

import com.ra.ss2.model.entity.Category;
import com.ra.ss2.model.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class CategoryDAOImpl implements CategoryDAO{
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Category> findAll() {
            List<Category> categories = new ArrayList<>();
            Session session = sessionFactory.openSession();
            try {
                System.out.println(1);
                session.beginTransaction();
                categories = session.createQuery("from Category", Category.class).list();
                session.getTransaction().commit();
            }catch (Exception e) {
                System.out.println(2);
                session.getTransaction().rollback();
            }finally {
                session.close();
            }
            return categories;
    }

    @Override
    public boolean saveOrUpdate(Category category) {
        return false;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Category findById(Integer id) {
        return null;
    }
}
