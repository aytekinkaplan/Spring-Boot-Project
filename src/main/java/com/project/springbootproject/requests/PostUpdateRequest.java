package com.project.springbootproject.requests;

import lombok.Data;

// This class represents a request object for updating an existing post.
// It contains fields such as title and text to be updated.
@Data
public class PostUpdateRequest {
    String title; // The updated title of the post.
    String text; // The updated text content of the post.
}
