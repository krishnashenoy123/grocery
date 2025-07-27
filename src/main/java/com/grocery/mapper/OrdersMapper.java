package com.grocery.mapper;

import com.grocery.model.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrdersMapper {
    List<Order> getAllOrders();

    int addOrder(Order order);

    int updateOrder(Order order);

    int deleteOrder(int orderId);

    Order getOrderById(int orderId);
}
