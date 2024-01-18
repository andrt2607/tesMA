package com.example.tesMA.tesMA.services;

import java.util.List;
import java.util.UUID;

import com.example.tesMA.tesMA.models.Forum;

public interface ForumService {
    List<Forum> getAllForums();
    Forum createForum(Forum forum);
    Forum updateForum(Forum forum);
    void deleteForum(UUID id);
    Forum getForumById(UUID id);
}
