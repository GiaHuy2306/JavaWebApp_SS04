package com.restaurant.bai3.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bai3/orders")
public class OrderController {
    @GetMapping("/{id}")
    public String getOrderById(@PathVariable("id") int id) {
        return "Chi tiet don hang so " + id;
    }
}
