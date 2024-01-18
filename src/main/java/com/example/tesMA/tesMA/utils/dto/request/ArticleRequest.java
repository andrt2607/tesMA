package com.example.tesMA.tesMA.utils.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ArticleRequest(
        @JsonProperty("title") String title,
        @JsonProperty("slug") String slug,
        @JsonProperty("body") String body,
        @JsonProperty("banner") String banner,
        @JsonProperty("image") String image,
        @JsonProperty("article_type") String articleType,
        @JsonProperty("article_status") String articleStatus,
        @JsonProperty("is_slide_show") int isSlideShow,
        @JsonProperty("counter") int counter,
        @JsonProperty("category_id") int categoryId
        ) {

}
