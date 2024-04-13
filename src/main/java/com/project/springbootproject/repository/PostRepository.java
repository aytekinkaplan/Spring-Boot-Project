package com.project.springbootproject.repository;

import com.project.springbootproject.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// This interface extends JpaRepository, which provides the basic CRUD operations for the Post entity.
// JpaRepository<Post, Long>: Specifies the entity type (Post) and the type of its primary key (Long).
public interface PostRepository extends JpaRepository<Post, Long> {

    // This method finds all posts associated with a specific user by their user ID.
    List<Post> findByUserId(Long userId); // <userId>
}
