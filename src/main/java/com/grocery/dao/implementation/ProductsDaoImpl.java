package com.grocery.dao.implementation;

import com.grocery.dao.ProductsDao;
import com.grocery.mapper.ProductsMapper;
import com.grocery.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductsDaoImpl implements ProductsDao {

    @Autowired
    private ProductsMapper productsMapper;

    @Override
    public List<Product> getAllProducts() {
        return productsMapper.getAllProducts();
    }

    @Override
    public int addProduct(Product product) {
        return productsMapper.addProduct(product);
    }

    @Override
    public int updateProduct(Product product) {
        return productsMapper.updateProduct(product);
    }

    @Override
    public int deleteProduct(int productId) {
        return productsMapper.deleteProduct(productId);
    }

    @Override
    public Product getProductByParam(int productId) {
        return productsMapper.getProductByParam(productId);
    }

}
