package com.ra.ss2.model.service.product;

import com.ra.ss2.model.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    boolean saveOrUpdate(Product product);
    void delete(Integer id);
    Product findById(Integer id);
}
