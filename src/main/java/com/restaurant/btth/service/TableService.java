package com.restaurant.btth.service;

import com.restaurant.btth.model.RestaurantTable;
import com.restaurant.btth.repository.TableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TableService {

    private final TableRepository tableRepository;

    @Autowired
    public TableService(TableRepository tableRepository) {
        this.tableRepository = tableRepository;
    }

    public List<RestaurantTable> filterByCapacity(int minCapacity) {
        return tableRepository.getAllTables().stream()
                .filter(t -> t.getCapacity() >= minCapacity)
                .collect(Collectors.toList());
    }

    public RestaurantTable getTableById(int id) {
        return tableRepository.getAllTables().stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void updateStatus(int id, String newStatus) {
        RestaurantTable table = getTableById(id);
        if (table != null) {
            table.setStatus(newStatus);
        }
    }

    public String deleteTable(int id) {
        RestaurantTable table = getTableById(id);
        if (table == null) {
            return "Khong tim thay ban!";
        }
        if ("Đang dùng".equals(table.getStatus())) {
            return "Loi: Khong the xoa ban khi co khach!";
        }
        tableRepository.removeTable(table);
        return "Xoa ban thanh cong!";
    }
}
