package com.grocery.dao;

import com.grocery.model.Product;

import java.util.List;

public interface ProductsDao {
    List<Product> getAllProducts();

    int addProduct(Product product);

    int updateProduct(Product product);

    int deleteProduct(int productId);

    Product getProductByParam(int productId);
}
