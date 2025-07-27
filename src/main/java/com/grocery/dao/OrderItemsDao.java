package com.grocery.dao;

import com.grocery.model.OrderItems;

import java.util.List;

public interface OrderItemsDao {
    List<OrderItems> getAllOrderItems();

    OrderItems getOrderItemsByParam(int orderItemId);

    int updateOrderItems(OrderItems orderItems);

    int addOrderItems(OrderItems orderItems);

    int deleteOrderItems(int orderItemId);
}
