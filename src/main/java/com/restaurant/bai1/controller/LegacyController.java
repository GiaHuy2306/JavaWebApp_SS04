package com.restaurant.bai1.controller;

import com.restaurant.bai1.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bai1/orders")
public class LegacyController {
    private final OrderService orderService;

    @Autowired
    public LegacyController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public String getAllOrders() {
        return orderService.getAllOrders();
    }

    @PostMapping
    public String getOrderById(Long id) {
        return orderService.getOrderById(id);
    }
}
