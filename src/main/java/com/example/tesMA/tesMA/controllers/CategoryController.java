package com.example.tesMA.tesMA.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.PutExchange;

import com.example.tesMA.tesMA.services.CategoryService;
import com.example.tesMA.tesMA.utils.dto.request.CategoryRequest;
import com.example.tesMA.tesMA.utils.dto.response.DefaultResponse;

@RestController
@RequestMapping("/v1/category")
public class CategoryController {
     @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<DefaultResponse> getAll() {
        return categoryService.getAllCategorys();
    }

    @PostMapping
    public ResponseEntity<DefaultResponse> create(@RequestBody CategoryRequest request) {
        return categoryService.createCategory(request);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DefaultResponse> update(@PathVariable int id, @RequestBody CategoryRequest request) {
        return categoryService.updateCategory(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DefaultResponse> delete(@PathVariable int id) {
        return categoryService.deleteCategory(id);
    }
}
