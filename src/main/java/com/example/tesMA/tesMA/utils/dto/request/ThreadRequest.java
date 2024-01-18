package com.example.tesMA.tesMA.utils.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ThreadRequest(
        @JsonProperty("title") String title,
        @JsonProperty("slug") String slug,
        @JsonProperty("counter") int counter
        // @JsonProperty("article_id") String articleId
        ) {

}