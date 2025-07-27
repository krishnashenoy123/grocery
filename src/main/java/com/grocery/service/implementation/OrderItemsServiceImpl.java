package com.grocery.service.implementation;

import com.grocery.dao.OrderItemsDao;
import com.grocery.model.OrderItems;
import com.grocery.service.OrderItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemsServiceImpl implements OrderItemsService {

    @Autowired
    private OrderItemsDao orderItemsDao;

    @Override
    public List<OrderItems> getAllOrderItems() {
        return orderItemsDao.getAllOrderItems();
    }

    @Override
    public OrderItems getOrderItemsByParam(int orderItemId) {
        return orderItemsDao.getOrderItemsByParam(orderItemId);
    }

    @Override
    public int updateOrderItems(OrderItems orderItems) {
        return orderItemsDao.updateOrderItems(orderItems);
    }

    @Override
    public int addOrderItems(OrderItems orderItems) {
        return orderItemsDao.addOrderItems(orderItems);
    }

    @Override
    public int deleteOrderItems(int orderItemId) {
        return orderItemsDao.deleteOrderItems(orderItemId);
    }
}
