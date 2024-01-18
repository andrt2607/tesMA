package com.example.tesMA.tesMA.models;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import com.example.tesMA.tesMA.utils.enums.ArticleStatus;
import com.example.tesMA.tesMA.utils.enums.ArticleType;
import com.example.tesMA.tesMA.utils.enums.TypeForum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "tb_m_articles")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, length = 50)
    private String slug;

    @Column(nullable = false,columnDefinition = "TEXT")
    private String body;

    @Column(nullable = false,columnDefinition = "TEXT")
    private String banner;

    @Column(nullable = false,columnDefinition = "TEXT")
    private String image;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false , name = "type")
    private ArticleType typeArticle;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false , name = "status")
    private ArticleStatus statusArticle;

    @Column(name = "is_slide_show",nullable = false, columnDefinition = "TINYINT")
    private byte isSlideShow;

    @Column(nullable = false,columnDefinition = "TEXT")
    private int counter;

    @Column(nullable = false)
    private Timestamp createdAt;
    
    @Column(nullable = false)
    private Timestamp updatedAt;

    // @ManyToMany(fetch = FetchType.EAGER)
    // @JoinTable(
    //         name = "article_categories",
    //         joinColumns = @JoinColumn(name = "article_id"),
    //         inverseJoinColumns = @JoinColumn(name = "category_id")
    // )
    // private List<Category> categories;

    // @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany(mappedBy = "articles")
    private List<Category> categories;
}
