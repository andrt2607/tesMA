package com.example.tesMA.tesMA.models;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import com.example.tesMA.tesMA.utils.enums.TypeForum;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "tb_m_forums")
public class Forum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String icon;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false , name = "type")
    private TypeForum typeForum;

    @Column(nullable = false)
    private Timestamp createdAt;
    
    @Column(nullable = false)
    private Timestamp updatedAt;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "forum")
    private List<Thread> threads;

    @ManyToOne
    @JoinColumn(name = "sub_forum_id")
    // @Column(name = "sub_forum_id")
    private Forum subForumId;

}
