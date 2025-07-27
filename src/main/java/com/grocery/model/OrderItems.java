package com.grocery.model;

import lombok.*;

import java.util.Objects;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItems {
    private int orderItemId;
    private int order_id;
    private int product_id;
    private int quantity;
    private Double price;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        OrderItems orderItems = (OrderItems) o;
        return orderItemId == orderItems.orderItemId && order_id == orderItems.order_id && product_id == orderItems.product_id && quantity == orderItems.quantity && Objects.equals(price, orderItems.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderItemId, order_id, product_id, quantity, price);
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "orderItemId=" + orderItemId +
                ", order_id=" + order_id +
                ", product_id=" + product_id +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
