package com.ra.ss2.model.service.category;

import com.ra.ss2.model.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    boolean saveOrUpdate(Category category);
    void delete(Integer id);
    Category findById(Integer id);
}
