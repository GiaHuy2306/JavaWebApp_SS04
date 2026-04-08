package com.restaurant.btth.repository;

import com.restaurant.btth.model.RestaurantTable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TableRepository {
    private List<RestaurantTable> tables = new ArrayList<>();

    public TableRepository() {
        // Khởi tạo Mock Data
        tables.add(new RestaurantTable(1, "Bàn số 1", 2, "Trống"));
        tables.add(new RestaurantTable(2, "Bàn số 2", 4, "Đang dùng"));
        tables.add(new RestaurantTable(3, "Bàn số 3", 8, "Trống"));
        tables.add(new RestaurantTable(4, "Bàn VIP 1", 12, "Đang dùng"));
    }

    public List<RestaurantTable> getAllTables() {
        return tables;
    }

    public void removeTable(RestaurantTable table) {
        tables.remove(table);
    }
}
