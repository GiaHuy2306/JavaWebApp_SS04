package com.restaurant.bai5.service;

import com.restaurant.bai5.repository.OrderManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderManagementService {

    private final OrderManagementRepository repository;

    @Autowired
    public OrderManagementService(OrderManagementRepository repository) {
        this.repository = repository;
    }

    public String getOrder(Long id) {
        return repository.findOrderById(id);
    }

    public String createNewOrder() {
        repository.saveOrder();
        return "Tạo đơn hàng thành công (POST - Not Idempotent)";
    }

    public String cancelOrder(Long id) {
        repository.deleteOrder(id);
        return "Hủy đơn hàng " + id + " thành công (DELETE - Idempotent)";
    }
}
