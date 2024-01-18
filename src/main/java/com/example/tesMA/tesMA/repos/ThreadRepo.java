package com.example.tesMA.tesMA.repos;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ThreadRepo extends JpaRepository<com.example.tesMA.tesMA.models.Thread, Integer>{
    
}
