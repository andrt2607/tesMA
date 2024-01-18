package com.example.tesMA.tesMA.services;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;

import com.example.tesMA.tesMA.models.Thread;
import com.example.tesMA.tesMA.utils.dto.request.ThreadRequest;
import com.example.tesMA.tesMA.utils.dto.request.VoteRequest;
import com.example.tesMA.tesMA.utils.dto.response.DefaultResponse;

public interface ThreadService {
    ResponseEntity<DefaultResponse> getAllThreads();
    ResponseEntity<DefaultResponse> createThread(ThreadRequest request);
    ResponseEntity<DefaultResponse> updateThread(int id, ThreadRequest request);
    ResponseEntity<DefaultResponse> deleteThread(int id);
    Thread getThreadById(int id);
}
