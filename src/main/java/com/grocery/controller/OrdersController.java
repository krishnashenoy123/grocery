package com.grocery.controller;

import com.grocery.model.Order;
import com.grocery.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @GetMapping("/orders")
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = ordersService.getAllOrders();
        if(orders.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(orders);
    }

    @PutMapping("/orders")
    public ResponseEntity<?> updateOrder(@RequestBody Order order) {
        if(order == null || order.getUser_id() <=0 || order.getOrder_status() == null) {
            return ResponseEntity.badRequest().body("Missing values for Order Price, Status or User id");
        }
        try {
            int rows = ordersService.updateOrder(order);
            if(rows > 0) {
                Order updatedOrder = ordersService.getOrderById(order.getOrder_id());
                return ResponseEntity.status(HttpStatus.CREATED).body(updatedOrder);
            }
            else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Could not update order due to server error.");
            }
        }  catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Validation Error: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unexpected Error: " + e.getMessage());
        }
    }

    @PostMapping("/orders")
    public ResponseEntity<?> addOrder(@RequestBody Order order) {
        if(order == null || order.getUser_id() <=0 || order.getOrder_price() < 0 || order.getOrder_status() == null) {
            return ResponseEntity.badRequest().body("Missing values for Order Price, Status or User id");
        }
        try {
            int rows = ordersService.addOrder(order);
            if(rows > 0) {
                return ResponseEntity.status(HttpStatus.CREATED).body("Order added successfully.");
            }
            else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add order.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }

    @DeleteMapping("/orders/{orderId}")
    public ResponseEntity<?> deleteOrder(@PathVariable int orderId) {
        try {
            int rows = ordersService.deleteOrder(orderId);
            if(rows > 0) {
                return ResponseEntity.noContent().build();
            }
            else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }
}
