package com.grocery.model;

import lombok.*;

import java.sql.Timestamp;
import java.util.Objects;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private int order_id;
    private int user_id;
    private Double order_price;
    private String order_status;
    private Timestamp order_date;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return order_id == order.order_id && user_id == order.user_id && Objects.equals(order_price, order.order_price) && Objects.equals(order_status, order.order_status) && Objects.equals(order_date, order.order_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order_id, user_id, order_price, order_status, order_date);
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", user_id=" + user_id +
                ", order_price=" + order_price +
                ", order_status='" + order_status + '\'' +
                ", order_date=" + order_date +
                '}';
    }
}
