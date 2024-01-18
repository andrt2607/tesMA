package com.example.tesMA.tesMA.controllers;

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

import com.example.tesMA.tesMA.services.ArticleService;
import com.example.tesMA.tesMA.utils.dto.request.ArticleRequest;
import com.example.tesMA.tesMA.utils.dto.response.DefaultResponse;

@RestController
@RequestMapping("/v1/article")
public class ArticleController {
     @Autowired
    private ArticleService articleService;

    @GetMapping
    public ResponseEntity<DefaultResponse> getAll() {
        return articleService.getAllArticles();
    }

    @PostMapping
    public ResponseEntity<DefaultResponse> create(@RequestBody ArticleRequest request) {
        return articleService.createArticle(request);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DefaultResponse> update(@PathVariable int id, @RequestBody ArticleRequest request) {
        return articleService.updateArticle(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DefaultResponse> delete(@PathVariable int id) {
        return articleService.deleteArticle(id);
    }
}
