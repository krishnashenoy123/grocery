package com.grocery.model;

import lombok.*;

import java.sql.Timestamp;
import java.util.Objects;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private int productId;
    private String productName;
    private String productDesc;
    private Double price;
    private int stock;
    private int category_id;
    private String image_url;
    private Timestamp created_d;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productId == product.productId && stock == product.stock && category_id == product.category_id && Objects.equals(productName, product.productName) && Objects.equals(productDesc, product.productDesc) && Objects.equals(price, product.price) && Objects.equals(image_url, product.image_url) && Objects.equals(created_d, product.created_d);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productName, productDesc, price, stock, category_id, image_url, created_d);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productDesc='" + productDesc + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", category_id=" + category_id +
                ", image_url='" + image_url + '\'' +
                ", created_d=" + created_d +
                '}';
    }
}
