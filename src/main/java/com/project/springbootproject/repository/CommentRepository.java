package com.project.springbootproject.repository;

import com.project.springbootproject.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

// This interface extends JpaRepository, which provides the basic CRUD operations for the Comment entity.
// JpaRepository<Comment, Long>: Specifies the entity type (Comment) and the type of its primary key (Long).
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
