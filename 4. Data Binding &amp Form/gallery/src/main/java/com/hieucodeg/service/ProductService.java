package com.hieucodeg.service;

import com.hieucodeg.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService {
    private static final Map<Integer, Product> products;

    static {

        products = new HashMap<>();
        products.put(1, new Product(1, "May giat", 4000000,"May chat luong cao","Tosiba"));
        products.put(2, new Product(2,"Dien thoai",200000,"Cuc gach","Nokia"));
        products.put(3, new Product(3, "Ti vi", 10000000,"May chat luong","LG"));
        products.put(4, new Product(4, "Tu lanh", 6000000,"May chat luong trung binh","XiaoYang"));
        products.put(5, new Product(5, "Dieu hoa", 5000000,"May chat luong thap","Tosiba"));
        products.put(6, new Product(6, "Lap top", 20000000,"May chat luong trung","Dell"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }


    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(Integer id) {
        return products.get(id);
    }

    @Override
    public Product findByName(String name) {
        for (Product product:products.values()) {
            if (name.toUpperCase().equals(product.getName().toUpperCase())) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void update(Integer id, Product product) {
        products.put(id, product);

    }

    @Override
    public void remove(Integer id) {
        products.remove(id);
    }
}
