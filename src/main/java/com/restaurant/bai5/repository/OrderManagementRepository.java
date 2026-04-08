package com.restaurant.bai5.repository;


import org.springframework.stereotype.Repository;

@Repository
public class OrderManagementRepository {

    public String findOrderById(Long id) {
        return "Dữ liệu đơn hàng chi tiết của mã số: " + id;
    }

    public void saveOrder() {
        System.out.println("Đã lưu đơn hàng vào Database");
    }

    public void deleteOrder(Long id) {
        System.out.println("Đã xóa đơn hàng ID " + id + " khỏi Database");
    }
}
