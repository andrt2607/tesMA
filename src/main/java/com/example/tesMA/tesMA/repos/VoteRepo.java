package com.example.tesMA.tesMA.repos;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tesMA.tesMA.models.Vote;

public interface VoteRepo extends JpaRepository<Vote, Integer>{
    
}
