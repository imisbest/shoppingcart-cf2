package com.csw.dao;

import com.csw.entity.Product;

import java.util.List;

public interface ProductDao {
    List<Product> queryPersonByArray();

    Integer countPage();

    Product getProductById(Integer id);

}
