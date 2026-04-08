package com.restaurant.bai4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
    @GetMapping("/bai4/products")
    public String getProducts(
            @RequestParam("category") String category,
            @RequestParam("limit") int limit,
            ModelMap model) {

        model.addAttribute("category", category)
                .addAttribute("limit", limit)
                .addAttribute("message", "Tìm kiếm thành công");

        return "productList";
    }
}
