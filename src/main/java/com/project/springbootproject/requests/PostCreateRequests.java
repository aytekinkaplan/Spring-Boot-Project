package com.project.springbootproject.requests;

import lombok.Data;

// This class represents a request object for creating a new post.
// It contains fields such as id, text, title, and userId.
@Data
public class PostCreateRequests {
    Long id; // The ID of the post.
    String text; // The text content of the post.
    String title; // The title of the post.
    Long userId; // The ID of the user who created the post.
}
