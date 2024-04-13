package com.project.springbootproject.repository;

import com.project.springbootproject.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
    
}
