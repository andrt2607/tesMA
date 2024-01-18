package com.example.tesMA.tesMA.models;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "tb_m_threads")
public class Thread {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, length = 50)
    private String slug;

    @Column(nullable = false)
    private int counter;

    @Column(nullable = false)
    private Timestamp createdAt;
    
    @Column(nullable = false)
    private Timestamp updatedAt;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "thread")
    private List<Post> posts;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Forum forum;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "thread", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    @JsonIgnore
    private Vote vote;
}
