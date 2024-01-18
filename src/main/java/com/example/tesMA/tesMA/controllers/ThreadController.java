package com.example.tesMA.tesMA.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// import com.example.tesMA.tesMA.services.threadService;
import com.example.tesMA.tesMA.services.ThreadService;
import com.example.tesMA.tesMA.utils.dto.request.ThreadRequest;
import com.example.tesMA.tesMA.utils.dto.response.DefaultResponse;

@RestController
@RequestMapping("/v1/thread")
public class ThreadController {
     @Autowired
    private ThreadService threadService;

    @GetMapping
    public ResponseEntity<DefaultResponse> getAll() {
        return threadService.getAllThreads();
    }

    @PostMapping
    public ResponseEntity<DefaultResponse> create(@RequestBody ThreadRequest request) {
        return threadService.createThread(request);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DefaultResponse> update(@PathVariable int id, @RequestBody ThreadRequest request) {
        return threadService.updateThread(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DefaultResponse> delete(@PathVariable int id) {
        return threadService.deleteThread(id);
    }
}
