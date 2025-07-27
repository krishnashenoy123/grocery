package com.grocery.dao.implementation;

import com.grocery.dao.OrdersDao;
import com.grocery.mapper.OrdersMapper;
import com.grocery.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrdersDaoImpl implements OrdersDao {

    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public List<Order> getAllOrders() {
        return ordersMapper.getAllOrders();
    }

    @Override
    public int addOrder(Order order) {
        return ordersMapper.addOrder(order);
    }

    @Override
    public int updateOrder(Order order) {
        return ordersMapper.updateOrder(order);
    }

    @Override
    public int deleteOrder(int orderId) {
        return ordersMapper.deleteOrder(orderId);
    }

    @Override
    public Order getOrderById(int orderId) {
        return ordersMapper.getOrderById(orderId);
    }
}
