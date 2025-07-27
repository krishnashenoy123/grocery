package com.grocery.service;

import com.grocery.model.Product;

import java.util.List;

public interface ProductsService {
    List<Product> getAllProducts();

    int addProduct(Product product);

    int updateProduct(Product product);

    int deleteProduct(int productId);

    Product getProductByParam(int productId);
}
