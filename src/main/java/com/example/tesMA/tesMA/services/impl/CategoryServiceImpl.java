package com.example.tesMA.tesMA.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.tesMA.tesMA.models.Article;
import com.example.tesMA.tesMA.models.Category;
import com.example.tesMA.tesMA.repos.ArticleRepo;
import com.example.tesMA.tesMA.repos.CategoryRepo;
import com.example.tesMA.tesMA.services.CategoryService;
import com.example.tesMA.tesMA.utils.Constant;
import com.example.tesMA.tesMA.utils.DateUtil;
import com.example.tesMA.tesMA.utils.dto.request.CategoryRequest;
import com.example.tesMA.tesMA.utils.dto.response.DefaultResponse;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo repo;

    @Autowired
    private ArticleRepo articleRepo;

    @Override
    public ResponseEntity<DefaultResponse> getAllCategorys() {
        DefaultResponse defaultResponse = new DefaultResponse();
        defaultResponse.setMessage(Constant.MSG_DATA_FOUND);
        defaultResponse.setData(repo.findAll());
        return ResponseEntity.ok().body(defaultResponse);
    }

    @Override
    public ResponseEntity<DefaultResponse> createCategory(CategoryRequest request) {
        Category category = new Category();
        category.setName(request.name());
        category.setCreatedAt(DateUtil.getCurrentTimestamp());
        category.setUpdatedAt(DateUtil.getCurrentTimestamp());

        ArrayList<Article> articles = new ArrayList<>();
        // articleRepo.findById(1).get();
        // articles.add(articleRepo.findById(1).get());
        category.setArticles(articles);
        DefaultResponse defaultResponse = new DefaultResponse();
        defaultResponse.setMessage(Constant.MSG_DATA_CREATED);
        defaultResponse.setData(repo.save(category));
        // repo.save(category);
        return ResponseEntity.created(null).body(defaultResponse);
    }

    @Override
    public ResponseEntity<DefaultResponse> updateCategory(int id, CategoryRequest request) {
        // UUID targetId = UUID.fromString(id);
        // System.out.println("ini id: " + id);
        // System.out.println("ini type data id: " + id.getClass());
        // if(!repo.existsById(id)) {
        //     DefaultResponse defaultResponse = new DefaultResponse();
        //     defaultResponse.setMessage(Constant.MSG_NOT_DATA_FOUND + " id: " + id);
        //     defaultResponse.setData(id);
        //     return ResponseEntity.badRequest().body(defaultResponse);
        // }
        Category targetCategory = getCategoryById(id);
        // Category category = new Category();
        // category.setId(id);
        targetCategory.setName(request.name());
        targetCategory.setCreatedAt(getCategoryById(id).getUpdatedAt());
        targetCategory.setUpdatedAt(DateUtil.getCurrentTimestamp());
        repo.save(targetCategory);
        DefaultResponse defaultResponse = new DefaultResponse();
        defaultResponse.setMessage(Constant.MSG_DATA_UPDATED);
        defaultResponse.setData(request);
        return ResponseEntity.ok().body(defaultResponse);
    }

    @Override
    public ResponseEntity<DefaultResponse> deleteCategory(int id) {
        if(!repo.existsById(id)) {
            DefaultResponse defaultResponse = new DefaultResponse();
            defaultResponse.setMessage(Constant.MSG_NOT_DATA_FOUND + " id: " + id);
            defaultResponse.setData(id);
            return ResponseEntity.badRequest().body(defaultResponse);
        }
        repo.deleteById(id);
        DefaultResponse defaultResponse = new DefaultResponse();
        defaultResponse.setMessage(Constant.MSG_DATA_DELETED + " id: " + id);
        defaultResponse.setData(id);
        return ResponseEntity.ok().body(defaultResponse);
    }

    @Override
    public Category getCategoryById(int id) {
        return repo.findById(id).get();
    }

}
