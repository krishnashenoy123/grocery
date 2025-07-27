package com.grocery.dao.implementation;

import com.grocery.dao.OrderItemsDao;
import com.grocery.mapper.OrderItemsMapper;
import com.grocery.model.OrderItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderItemsDaoImpl implements OrderItemsDao {

    @Autowired
    private OrderItemsMapper orderItemsMapper;

    @Override
    public List<OrderItems> getAllOrderItems() {
        return orderItemsMapper.getAllOrderItems();
    }

    @Override
    public OrderItems getOrderItemsByParam(int orderItemId) {
        return orderItemsMapper.getOrderItemsByParam(orderItemId);
    }

    @Override
    public int updateOrderItems(OrderItems orderItems) {
        return orderItemsMapper.updateOrderItems(orderItems);
    }

    @Override
    public int addOrderItems(OrderItems orderItems) {
        return orderItemsMapper.addOrderItems(orderItems);
    }

    @Override
    public int deleteOrderItems(int orderItemId) {
        return orderItemsMapper.deleteOrderItems(orderItemId);
    }
}
