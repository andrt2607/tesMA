package com.example.tesMA.tesMA.models;

import java.sql.Timestamp;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import liquibase.logging.mdc.customobjects.History;
import lombok.Data;

@Entity
@Data
@Table(name = "tb_m_votes")
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "up_count")
    private int upCount;

    @Column(name = "down_count")
    private int downCount;

    @Column(nullable = false)
    private Timestamp createdAt;
    
    @Column(nullable = false)
    private Timestamp updatedAt;

    @JsonProperty(access = JsonProperty.Access.READ_WRITE)
    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    @JsonIgnore
    private Thread thread;
}
