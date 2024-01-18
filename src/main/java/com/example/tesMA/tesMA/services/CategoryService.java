package com.example.tesMA.tesMA.services;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;

import com.example.tesMA.tesMA.models.Category;
import com.example.tesMA.tesMA.utils.dto.request.CategoryRequest;
import com.example.tesMA.tesMA.utils.dto.response.DefaultResponse;

public interface CategoryService {
    ResponseEntity<DefaultResponse> getAllCategorys();
    ResponseEntity<DefaultResponse> createCategory(CategoryRequest request);
    ResponseEntity<DefaultResponse> updateCategory(int id, CategoryRequest request);
    ResponseEntity<DefaultResponse> deleteCategory(int id);
    Category getCategoryById(int id);
}
