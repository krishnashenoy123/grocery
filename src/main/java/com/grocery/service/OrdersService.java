package com.grocery.service;

import com.grocery.model.Order;

import java.util.List;

public interface OrdersService {
    List<Order> getAllOrders();

    int addOrder(Order order);

    int updateOrder(Order order);

    int deleteOrder(int orderId);

    Order getOrderById(int orderId);
}
