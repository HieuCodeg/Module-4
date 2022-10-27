package com.hieucodeg.service;

import com.hieucodeg.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void save(Product product);

    Product findById(Integer id);
    Product findByName(String name);

    void update(Integer id, Product product);

    void remove(Integer id);
}
