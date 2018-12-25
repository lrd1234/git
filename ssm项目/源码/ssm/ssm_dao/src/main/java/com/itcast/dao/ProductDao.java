package com.itcast.dao;

import com.itcast.domain.Product;

import java.util.List;

public interface ProductDao {
  /*查询所有产品*/
  List<Product> findAll();

  Product findById(String productid);
}
