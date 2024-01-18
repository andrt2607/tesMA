package com.example.tesMA.tesMA.repos;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.tesMA.tesMA.models.Article;

import jakarta.transaction.Transactional;



@Repository
@Transactional
public interface ArticleRepo extends JpaRepository<Article, Integer>{
     @Modifying
    @Query(value = "INSERT INTO article_categories (article_id, category_id) values (:article_id, :category_id)", nativeQuery = true)
    void insertArticleCategory(@Param("article_id") Integer articleId, @Param("category_id") Integer categoryId);
}
