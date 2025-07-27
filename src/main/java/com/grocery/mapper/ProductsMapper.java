package com.grocery.mapper;

import com.grocery.model.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductsMapper {
    List<Product> getAllProducts();

    int addProduct(Product product);

    int updateProduct(Product product);

    int deleteProduct(int productId);

    Product getProductByParam(int productId);
}
