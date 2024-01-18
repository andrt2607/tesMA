package com.example.tesMA.tesMA.utils.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

// @Data
public record VoteRequest(
        @JsonProperty("up_count") int upCount,
        @JsonProperty("down_count") int downCount
        // @JsonProperty("article_id") String articleId
        ) {

}
