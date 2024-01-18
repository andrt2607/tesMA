package com.example.tesMA.tesMA.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.tesMA.tesMA.models.Article;
import com.example.tesMA.tesMA.models.Category;
import com.example.tesMA.tesMA.repos.ArticleRepo;
import com.example.tesMA.tesMA.repos.CategoryRepo;
import com.example.tesMA.tesMA.services.ArticleService;
import com.example.tesMA.tesMA.utils.Constant;
import com.example.tesMA.tesMA.utils.DateUtil;
import com.example.tesMA.tesMA.utils.dto.request.ArticleRequest;
import com.example.tesMA.tesMA.utils.dto.response.DefaultResponse;

@Service
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    private ArticleRepo repo;

    @Autowired
    private CategoryRepo categoryRepo;


    @Override
    public ResponseEntity<DefaultResponse> getAllArticles() {
        DefaultResponse defaultResponse = new DefaultResponse();
        defaultResponse.setMessage(Constant.MSG_DATA_FOUND);
        defaultResponse.setData(repo.findAll());
        return ResponseEntity.ok().body(defaultResponse);
    }

    @Override
    public ResponseEntity<DefaultResponse> createArticle(ArticleRequest request) {
        Category targetCategory = categoryRepo.findById(request.categoryId()).get();
        Article article = new Article();
        article.setTitle(request.title());
        article.setSlug(request.slug());
        article.setCounter(request.counter());
        // article.setCategories(targetCategory);
        article.setCreatedAt(DateUtil.getCurrentTimestamp());
        article.setUpdatedAt(DateUtil.getCurrentTimestamp());
        DefaultResponse defaultResponse = new DefaultResponse();
        defaultResponse.setMessage(Constant.MSG_DATA_CREATED);
        defaultResponse.setData(repo.save(article));
        return ResponseEntity.status(HttpStatus.CREATED).body(defaultResponse);
    }

    @Override
    public ResponseEntity<DefaultResponse> updateArticle(int id, ArticleRequest request) {
        Category targetCategory = categoryRepo.findById(request.categoryId()).get();
        Article article = getArticleById(id);
        article.setTitle(request.title());
        article.setSlug(request.slug());
        article.setCounter(request.counter());
        // article.setCategories(targetCategory);
        article.setCreatedAt(DateUtil.getCurrentTimestamp());
        article.setUpdatedAt(DateUtil.getCurrentTimestamp());
        DefaultResponse defaultResponse = new DefaultResponse();
        defaultResponse.setMessage(Constant.MSG_DATA_CREATED);
        defaultResponse.setData(repo.save(article));
        return ResponseEntity.status(HttpStatus.CREATED).body(defaultResponse);
    }

    @Override
    public ResponseEntity<DefaultResponse> deleteArticle(int id) {
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
    public Article getArticleById(int id) {
        return repo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Article ID %d Not Found !!", id)));
    }
    
}
