package com.example.tesMA.tesMA.services;

import java.util.List;
import java.util.UUID;

import com.example.tesMA.tesMA.models.Article;

public interface ArticleService {
    List<Article> getAllArticles();
    Article createArticle(Article article);
    Article updateArticle(Article article);
    void deleteArticle(UUID id);
    Article getArticleById(UUID id);
}
