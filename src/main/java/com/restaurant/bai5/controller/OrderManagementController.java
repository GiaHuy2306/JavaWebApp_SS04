package com.restaurant.bai5.controller;

import com.restaurant.bai5.service.OrderManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bai5/orders")
public class OrderManagementController {
    private final OrderManagementService service;

    @Autowired
    public OrderManagementController(OrderManagementService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public String viewOrder(@PathVariable("id") Long id) {
        return service.getOrder(id);
    }

    @PostMapping
    public String createOrder() { return "Tao don hang moi"; }

    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable("id") Long id) { return "Huy don hang " + id; }

    @ExceptionHandler(org.springframework.web.method.annotation.MethodArgumentTypeMismatchException.class)
    public String handleTypeMismatch() {
        return "Loi: ID don hang ko hop le!";
    }
}
