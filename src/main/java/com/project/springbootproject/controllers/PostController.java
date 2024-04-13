package com.project.springbootproject.controllers;

import com.project.springbootproject.entities.Post;
import com.project.springbootproject.requests.PostCreateRequests;
import com.project.springbootproject.requests.PostUpdateRequest;
import com.project.springbootproject.services.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    // Constructor injection for PostService
    public PostController(PostService postService) {
        this.postService = postService;
    }

    // Endpoint to retrieve all posts
    @GetMapping
    public List<Post> getAllPosts(@RequestParam Optional<Long> userId) {
        return postService.getAllPosts(userId);
    }

    // Endpoint to create a new post
    @PostMapping
    public Post createOnePost(@RequestBody PostCreateRequests newPostRequest) {
        return postService.createOnePost(newPostRequest);
    }

    // Endpoint to retrieve a specific post by ID
    @GetMapping("/{postId}")
    public Post getPost(@PathVariable Long postId) {
        return postService.getOnePostById(postId);
    }

    // Endpoint to update an existing post by ID
    @PutMapping("/{postId}")
    public Post updateOnePost(@PathVariable Long postId, @RequestBody PostUpdateRequest updatePost) {
        return postService.updateOnePostById(postId, updatePost);
    }

    // Endpoint to delete an existing post by ID
    @DeleteMapping("/{postId}")
    public void deleteOnePost(@PathVariable Long postId) {
        postService.deleteOnePostById(postId);
    }
}

// Explanation:
// @RestController: This annotation indicates that the class defines a RESTful controller. It automatically serializes
// return objects into JSON and binds the HTTP request body to method parameters.
// @RequestMapping("/posts"): Specifies the base URI path for all HTTP requests handled by this controller.
// private final PostService postService;: Declares a private field postService of type PostService which will be
// injected using constructor-based dependency injection.
// PostController(PostService postService): Constructor for PostController that injects the PostService bean.
// @GetMapping: Handles HTTP GET requests. In this case, it's used to retrieve all posts or a specific post by ID.
// @PostMapping: Handles HTTP POST requests. It's used to create a new post.
// @PutMapping: Handles HTTP PUT requests. It's used to update an existing post.
// @DeleteMapping: Handles HTTP DELETE requests. It's used to delete an existing post.
// @RequestParam Optional<Long> userId: Specifies that the method parameter userId is an optional query parameter.
// This parameter allows filtering posts by user ID.
// @RequestBody: Indicates that the method parameter should be bound to the body of the HTTP request. In this case,
// it's used to create a new post or update an existing one.
// @PathVariable: Used to bind method parameters to URI template variables. In this case, it's used to retrieve a
// specific post by its ID or to delete a post by its ID.
// List<Post>: The return type of methods that retrieve multiple posts.
// Post: The return type of methods that retrieve a single post.
// void: The return type of methods that perform operations like creating or deleting a post, where no specific
// data needs to be returned.
