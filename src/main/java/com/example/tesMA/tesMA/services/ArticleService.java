package com.example.tesMA.tesMA.services;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;

import com.example.tesMA.tesMA.models.Article;
import com.example.tesMA.tesMA.utils.dto.request.ArticleRequest;
import com.example.tesMA.tesMA.utils.dto.response.DefaultResponse;

public interface ArticleService {
    ResponseEntity<DefaultResponse> getAllArticles();
    ResponseEntity<DefaultResponse> createArticle(ArticleRequest request);
    ResponseEntity<DefaultResponse> updateArticle(int id, ArticleRequest request);
    ResponseEntity<DefaultResponse> deleteArticle(int id);
    Article getArticleById(int id);
}
