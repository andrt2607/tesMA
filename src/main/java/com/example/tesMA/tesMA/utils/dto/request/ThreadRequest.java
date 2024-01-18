package com.example.tesMA.tesMA.utils.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ThreadRequest(
        @JsonProperty("title") String title,
        @JsonProperty("slug") String slug,
        @JsonProperty("counter") int counter,
        @JsonProperty("up_count") int upCount,
        @JsonProperty("down_count") int downCount,
        @JsonProperty("forum_name") String forumName,
        @JsonProperty("forum_desc") String forumDesc,
        @JsonProperty("forum_icon") String icon,
        @JsonProperty("forum_type") String forumType
        // @JsonProperty("article_id") String articleId
        ) {

}