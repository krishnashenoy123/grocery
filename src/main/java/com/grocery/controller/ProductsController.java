package com.grocery.controller;

import com.grocery.model.Product;
import com.grocery.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productsService.getAllProducts();
        if(products.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(products);
    }

    @PutMapping("/products")
    public ResponseEntity<?> updateProduct(@RequestBody Product product){
        if(product == null || product.getProductName() == null || product.getProductDesc() == null
                || product.getPrice() <0){
            return ResponseEntity.badRequest().body("Missing values for Product Name, Desc or Price");
        }
        try{
            int rows = productsService.updateProduct(product);
            if(rows > 0){
                Product updatedProduct = productsService.getProductByParam(product.getProductId());
                return ResponseEntity.status(HttpStatus.CREATED).body(updatedProduct);
            }
            else{
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Could not update product due to server error.");
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Validation Error: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unexpected Error: " + e.getMessage());
        }
    }

    @PostMapping("/products")
    public ResponseEntity<?> addProduct(@RequestBody Product product) {
        if (product == null || product.getProductName() == null || product.getProductDesc() == null
                || product.getPrice() == null || product.getPrice() < 0) {
            return ResponseEntity.badRequest().body("Invalid product data");
        }
        try {
            int rows = productsService.addProduct(product);
            if (rows > 0) {
                return ResponseEntity.status(HttpStatus.CREATED).body("Product added successfully.");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add product.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }

    @DeleteMapping("/products/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable int productId) {
        try {
            int rows = productsService.deleteProduct(productId);
            if (rows > 0) {
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }
}
