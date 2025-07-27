package com.grocery.mapper;

import com.grocery.model.OrderItems;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderItemsMapper {
    List<OrderItems> getAllOrderItems();

    OrderItems getOrderItemsByParam(int orderItemId);

    int updateOrderItems(OrderItems orderItems);

    int addOrderItems(OrderItems orderItems);

    int deleteOrderItems(int orderItemId);
}
