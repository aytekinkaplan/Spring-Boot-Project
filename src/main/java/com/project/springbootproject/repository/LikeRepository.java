package com.project.springbootproject.repository;

import com.project.springbootproject.entities.Like;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {
}
