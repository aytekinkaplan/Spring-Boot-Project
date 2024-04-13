package com.project.springbootproject.services;

import com.project.springbootproject.entities.Post;
import com.project.springbootproject.entities.User;
import com.project.springbootproject.repository.PostRepository;
import com.project.springbootproject.requests.PostCreateRequests;
import com.project.springbootproject.requests.PostUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// This class provides services related to managing posts.
@Service
public class PostService {
    private final PostRepository postRepository;
    private final UserService userService;

    // Constructor for PostService that injects the PostRepository and UserService beans.
    public PostService(PostRepository postRepository, UserService userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }

    // Retrieves all posts or posts filtered by user ID if specified.
    public List<Post> getAllPosts(Optional<Long> userId) {
        if (userId.isPresent())
            return postRepository.findByUserId(userId.get());
        return postRepository.findAll();
    }

    // Retrieves a post by its ID.
    public Post getOnePostById(Long postId) {
        return postRepository.findById(postId).orElse(null);
    }

    // Saves a new post.
    public Post saveOnePost(Post newPost) {
        return postRepository.save(newPost);
    }

    // Creates a new post using the provided request object.
    public Post createOnePost(PostCreateRequests newPostRequest) {
        User user = userService.getOneUser(newPostRequest.getUserId());
        if (user == null)
            return null;
        Post toSave = new Post();
        toSave.setId(newPostRequest.getId());
        toSave.setText(newPostRequest.getText());
        toSave.setTitle(newPostRequest.getTitle());
        toSave.setUser(user);
        return postRepository.save(toSave);
    }

    // Updates an existing post by its ID using the provided update request object.
    public Post updateOnePostById(Long postId, PostUpdateRequest updatePost) {
        Optional<Post> post = postRepository.findById(postId);
        if (post.isPresent()) {
            Post toUpdate = post.get();
            toUpdate.setText(updatePost.getText());
            toUpdate.setTitle(updatePost.getTitle());
            postRepository.save(toUpdate);
            return toUpdate;
        }
        return null;
    }

    // Deletes a post by its ID.
    public void deleteOnePostById(Long postId) {
        postRepository.deleteById(postId);
    }
}
