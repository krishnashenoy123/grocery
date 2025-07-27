package com.grocery.service.implementation;

import com.grocery.dao.ProductsDao;
import com.grocery.model.Product;
import com.grocery.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsServiceImpl implements ProductsService {

    @Autowired
    private ProductsDao productsDao;

    @Override
    public List<Product> getAllProducts() {
        return productsDao.getAllProducts();
    }

    @Override
    public int addProduct(Product product) {
        return productsDao.addProduct(product);
    }

    @Override
    public int updateProduct(Product product) {
        return productsDao.updateProduct(product);
    }

    @Override
    public int deleteProduct(int productId) {
        return productsDao.deleteProduct(productId);
    }

    @Override
    public Product getProductByParam(int productId) {
        return productsDao.getProductByParam(productId);
    }
}
