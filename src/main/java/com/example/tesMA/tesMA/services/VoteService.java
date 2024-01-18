package com.example.tesMA.tesMA.services;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;

import com.example.tesMA.tesMA.models.Vote;
import com.example.tesMA.tesMA.utils.dto.request.VoteRequest;
import com.example.tesMA.tesMA.utils.dto.response.DefaultResponse;

public interface VoteService {
    ResponseEntity<DefaultResponse> getAllVotes();
    ResponseEntity<DefaultResponse> createVote(VoteRequest request);
    ResponseEntity<DefaultResponse> updateVote(int id, VoteRequest request);
    ResponseEntity<DefaultResponse> deleteVote(int id);
    Vote getVoteById(int id);
}
