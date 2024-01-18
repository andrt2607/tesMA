package com.example.tesMA.tesMA.repos;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tesMA.tesMA.models.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer>{
    
}
