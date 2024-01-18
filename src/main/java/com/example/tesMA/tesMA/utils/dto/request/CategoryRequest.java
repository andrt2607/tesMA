package com.example.tesMA.tesMA.utils.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

// @Data
public record CategoryRequest(
        @JsonProperty("name") String name
        // @JsonProperty("article_id") String articleId
        ) {

}
