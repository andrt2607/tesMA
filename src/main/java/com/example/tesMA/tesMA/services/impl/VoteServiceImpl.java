package com.example.tesMA.tesMA.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.tesMA.tesMA.models.Category;
import com.example.tesMA.tesMA.models.Vote;
import com.example.tesMA.tesMA.repos.CategoryRepo;
import com.example.tesMA.tesMA.repos.VoteRepo;
import com.example.tesMA.tesMA.services.VoteService;
import com.example.tesMA.tesMA.utils.Constant;
import com.example.tesMA.tesMA.utils.DateUtil;
import com.example.tesMA.tesMA.utils.dto.request.VoteRequest;
import com.example.tesMA.tesMA.utils.dto.response.DefaultResponse;

@Service
public class VoteServiceImpl implements VoteService {

    @Autowired
    private VoteRepo repo;

    @Override
    public ResponseEntity<DefaultResponse> getAllVotes() {
       DefaultResponse defaultResponse = new DefaultResponse();
        defaultResponse.setMessage(Constant.MSG_DATA_FOUND);
        defaultResponse.setData(repo.findAll());
        return ResponseEntity.ok().body(defaultResponse);
    }

    @Override
    public ResponseEntity<DefaultResponse> createVote(VoteRequest request) {
        Vote vote = new Vote();
        vote.setUpCount(request.upCount());
        vote.setDownCount(request.downCount());
        vote.setCreatedAt(DateUtil.getCurrentTimestamp());
        vote.setUpdatedAt(DateUtil.getCurrentTimestamp());
        DefaultResponse defaultResponse = new DefaultResponse();
        defaultResponse.setMessage(Constant.MSG_DATA_CREATED);
        defaultResponse.setData(repo.save(vote));
        // repo.save(category);
        return ResponseEntity.created(null).body(defaultResponse);
    }

    @Override
    public ResponseEntity<DefaultResponse> updateVote(int id, VoteRequest request) {
        Vote vote = getVoteById(id);
        // Category category = new Category();
        // category.setId(id);
        vote.setId(vote.getId());
        vote.setUpCount(request.upCount());
        vote.setDownCount(request.downCount());
        vote.setCreatedAt(getVoteById(id).getUpdatedAt());
        vote.setUpdatedAt(DateUtil.getCurrentTimestamp());
        repo.save(vote);
        DefaultResponse defaultResponse = new DefaultResponse();
        defaultResponse.setMessage(Constant.MSG_DATA_UPDATED);
        defaultResponse.setData(request);
        return ResponseEntity.ok().body(defaultResponse);
    }

    @Override
    public ResponseEntity<DefaultResponse> deleteVote(int id) {
        if(!repo.existsById(id)) {
            DefaultResponse defaultResponse = new DefaultResponse();
            defaultResponse.setMessage(Constant.MSG_NOT_DATA_FOUND + " id: " + id);
            defaultResponse.setData(id);
            return ResponseEntity.badRequest().body(defaultResponse);
        }
        repo.deleteById(id);
        DefaultResponse defaultResponse = new DefaultResponse();
        defaultResponse.setMessage(Constant.MSG_DATA_DELETED + " id: " + id);
        defaultResponse.setData(id);
        return ResponseEntity.ok().body(defaultResponse);
    }

    @Override
    public Vote getVoteById(int id) {
        return repo.findById(id).get();
    }
    
}
