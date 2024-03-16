package com.learning.blog.payloads;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostPaginationResponse {
    private List<PostDto> posts;
    private long totalElements;
    private long totalPages;
    private long pageSize;
    private long pageNo;
    private boolean isLastPage;
}
