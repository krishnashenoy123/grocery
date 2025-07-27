package com.grocery.controller;

import com.grocery.model.OrderItems;
import com.grocery.service.OrderItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderItemsController {
    @Autowired
    private OrderItemsService orderItemsService;

    @GetMapping("/orderItems")
    public ResponseEntity<List<OrderItems>> getAllOrderItems() {
        List<OrderItems> orderItems = orderItemsService.getAllOrderItems();
        if(orderItems.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(orderItems);
    }

    @PutMapping("/orderItems")
    public ResponseEntity<?> updateOrderItem(@RequestBody OrderItems orderItems) {
        if(orderItems == null || orderItems.getOrder_id() < 0 || orderItems.getProduct_id() < 0 || orderItems.getQuantity() < 0
                || orderItems.getPrice() < 0) {
            return ResponseEntity.badRequest().body("Missing values for Order Id, Product Id, Quantity or Price.");
        }
        try {
            int rows = orderItemsService.updateOrderItems(orderItems);
            if (rows > 0) {
                OrderItems updatedOrderItems = orderItemsService.getOrderItemsByParam(orderItems.getOrderItemId());
                return ResponseEntity.status(HttpStatus.CREATED).body(updatedOrderItems);
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                        body("Could not update order item due to server error.");
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Validation Error: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unexpected Error: " + e.getMessage());
        }
    }

    @PostMapping("/orderItems")
    public ResponseEntity<?> addOrderItem(@RequestBody OrderItems orderItems) {
        if (orderItems == null || orderItems.getOrder_id() < 0 || orderItems.getProduct_id() < 0 || orderItems.getQuantity() < 0
                || orderItems.getPrice() < 0) {
            return ResponseEntity.badRequest().body("Missing values for Order Id, Product Id, Quantity or Price.");
        }
        try {
            int rows = orderItemsService.addOrderItems(orderItems);
            if (rows > 0) {
                return ResponseEntity.status(HttpStatus.CREATED).body("Order item added successfully.");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add Order Item.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }

    @DeleteMapping("/orderItems/{orderItemId}")
    public ResponseEntity<?> deleteOrderItem(@PathVariable("orderItemId") int orderItemId) {
        try {
            int rows = orderItemsService.deleteOrderItems(orderItemId);
            if (rows > 0) {
                return ResponseEntity.status(HttpStatus.OK).body("Order item deleted successfully.");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete Order Item.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }
}
