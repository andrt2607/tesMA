package com.example.tesMA.tesMA.services.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.tesMA.tesMA.models.Category;
import com.example.tesMA.tesMA.models.Forum;
import com.example.tesMA.tesMA.models.Thread;
import com.example.tesMA.tesMA.models.Vote;
import com.example.tesMA.tesMA.repos.CategoryRepo;
import com.example.tesMA.tesMA.repos.ThreadRepo;
import com.example.tesMA.tesMA.repos.VoteRepo;
import com.example.tesMA.tesMA.services.ThreadService;
import com.example.tesMA.tesMA.utils.Constant;
import com.example.tesMA.tesMA.utils.DateUtil;
import com.example.tesMA.tesMA.utils.dto.request.ThreadRequest;
import com.example.tesMA.tesMA.utils.dto.request.VoteRequest;
import com.example.tesMA.tesMA.utils.dto.response.DefaultResponse;
import com.example.tesMA.tesMA.utils.enums.TypeForum;

@Service
public class ThreadServiceImpl implements ThreadService{

    @Autowired
    private ThreadRepo repo;

    @Override
    public ResponseEntity<DefaultResponse> getAllThreads() {
        DefaultResponse defaultResponse = new DefaultResponse();
        defaultResponse.setMessage(Constant.MSG_DATA_FOUND);
        defaultResponse.setData(repo.findAll());
        return ResponseEntity.ok().body(defaultResponse);
    }

    @Override
    public ResponseEntity<DefaultResponse> createThread(ThreadRequest request) {
        Thread newThread = new Thread();
        newThread.setTitle(request.title());
        newThread.setSlug(request.slug());
        newThread.setCounter(request.counter());
        Vote vote = new Vote();
        vote.setUpCount(request.upCount());
        vote.setDownCount(request.downCount());
        vote.setCreatedAt(DateUtil.getCurrentTimestamp());
        vote.setUpdatedAt(DateUtil.getCurrentTimestamp());
        vote.setThread(newThread);
        newThread.setVote(vote);
        newThread.setCreatedAt(DateUtil.getCurrentTimestamp());
        newThread.setUpdatedAt(DateUtil.getCurrentTimestamp());
        Forum forum = new Forum();
        forum.setName(request.forumName());
        forum.setDescription(request.forumDesc());
        forum.setIcon(request.icon());
        forum.setTypeForum(TypeForum.valueOf(request.forumType()));
        forum.setCreatedAt(DateUtil.getCurrentTimestamp());
        forum.setUpdatedAt(DateUtil.getCurrentTimestamp());
        newThread.setForum(forum);
        repo.save(newThread);
        DefaultResponse defaultResponse = new DefaultResponse();
        defaultResponse.setMessage(Constant.MSG_DATA_CREATED);
        defaultResponse.setData(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(defaultResponse);
    }

    /**
     * Only need to create/save thread
     */
    @Override
    public ResponseEntity<DefaultResponse> updateThread(int id, ThreadRequest request) {
        Thread newThread = getThreadById(id);
        newThread.setTitle(request.title());
        newThread.setSlug(request.slug());
        newThread.setCounter(request.counter());
        Vote vote = new Vote();
        vote.setUpCount(request.upCount());
        vote.setDownCount(request.downCount());
        vote.setCreatedAt(DateUtil.getCurrentTimestamp());
        vote.setUpdatedAt(DateUtil.getCurrentTimestamp());
        vote.setThread(newThread);
        newThread.setVote(vote);
        newThread.setCreatedAt(DateUtil.getCurrentTimestamp());
        newThread.setUpdatedAt(DateUtil.getCurrentTimestamp());
        Forum forum = new Forum();
        forum.setName(request.forumName());
        forum.setDescription(request.forumDesc());
        forum.setIcon(request.icon());
        forum.setTypeForum(TypeForum.valueOf(request.forumType()));
        forum.setCreatedAt(DateUtil.getCurrentTimestamp());
        forum.setUpdatedAt(DateUtil.getCurrentTimestamp());
        newThread.setForum(forum);
        repo.save(newThread);
        DefaultResponse defaultResponse = new DefaultResponse();
        defaultResponse.setMessage(Constant.MSG_DATA_FOUND);
        defaultResponse.setData(request);
        return ResponseEntity.status(HttpStatus.OK).body(defaultResponse);
    }

    @Override
    public ResponseEntity<DefaultResponse> deleteThread(int id) {
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
    public Thread getThreadById(int id) {
        return repo.findById(id).get();
    }

    
    
}
