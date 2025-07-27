package com.grocery.service.implementation;

import com.grocery.dao.OrdersDao;
import com.grocery.model.Order;
import com.grocery.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersDao ordersDao;

    @Override
    public List<Order> getAllOrders() {
        return ordersDao.getAllOrders();
    }

    @Override
    public int addOrder(Order order) {
        return ordersDao.addOrder(order);
    }

    @Override
    public int updateOrder(Order order) {
        return ordersDao.updateOrder(order);
    }

    @Override
    public int deleteOrder(int orderId) {
        return ordersDao.deleteOrder(orderId);
    }

    @Override
    public Order getOrderById(int orderId) {
        return ordersDao.getOrderById(orderId);
    }
}
