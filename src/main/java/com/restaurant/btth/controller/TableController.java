package com.restaurant.btth.controller;

import com.restaurant.btth.model.RestaurantTable;
import com.restaurant.btth.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin/tables")
public class TableController {

    private final TableService tableService;

    @Autowired
    public TableController(TableService tableService) {
        this.tableService = tableService;
    }

    @GetMapping("/list")
    public String listTables(
            @RequestParam(value = "cap", defaultValue = "0") int cap,
            ModelMap model) {

        if (cap < 0) {
            model.addAttribute("error", "Sức chứa không được là số âm!");
            cap = 0;
        }

        List<RestaurantTable> tables = tableService.filterByCapacity(cap);
        model.addAttribute("tables", tables);
        model.addAttribute("currentCap", cap);
        return "table-list";
    }

    @GetMapping("/view/{id}")
    public ModelAndView viewTableDetail(@PathVariable("id") int id) {
        RestaurantTable table = tableService.getTableById(id);

        ModelAndView mav = new ModelAndView("table-detail");
        if (table == null) {
            mav.addObject("error", "Bàn không tồn tại!");
        } else {
            mav.addObject("table", table);
        }
        return mav;
    }

    @PostMapping("/update-status")
    public String updateStatus(
            @RequestParam("id") int id,
            @RequestParam("status") String status) {
        tableService.updateStatus(id, status);
        return "redirect:/admin/tables/list";
    }

    @PostMapping("/delete/{id}")
    public String deleteTable(@PathVariable("id") int id, ModelMap model) {
        String resultMsg = tableService.deleteTable(id);

        model.addAttribute("message", resultMsg);

        model.addAttribute("tables", tableService.filterByCapacity(0));
        return "table-list";
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ModelAndView handleTypeMismatchException(MethodArgumentTypeMismatchException ex) {
        ModelAndView mav = new ModelAndView("error-page");
        mav.addObject("errorMessage", "Đường dẫn không hợp lệ. Tham số phải là một con số, nhưng bạn đã nhập: " + ex.getValue());
        return mav;
    }
}
