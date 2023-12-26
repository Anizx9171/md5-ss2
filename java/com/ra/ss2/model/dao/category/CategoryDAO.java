package com.ra.ss2.model.dao.category;

import com.ra.ss2.model.entity.Category;
import com.ra.ss2.model.entity.Product;

import java.util.List;

public interface CategoryDAO {
    List<Category> findAll();
    boolean saveOrUpdate(Category category);
    void delete(Integer id);
    Category findById(Integer id);
}
