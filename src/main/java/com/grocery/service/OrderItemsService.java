package com.grocery.service;

import com.grocery.model.OrderItems;

import java.util.List;

public interface OrderItemsService {
    List<OrderItems> getAllOrderItems();

    OrderItems getOrderItemsByParam(int orderItemId);

    int updateOrderItems(OrderItems orderItems);

    int addOrderItems(OrderItems orderItems);

    int deleteOrderItems(int orderItemId);
}
