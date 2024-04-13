package com.project.springbootproject.repository;

import com.project.springbootproject.entities.Like;
import org.springframework.data.jpa.repository.JpaRepository;

// This interface extends JpaRepository, which provides the basic CRUD operations for the Like entity.
// JpaRepository<Like, Long>: Specifies the entity type (Like) and the type of its primary key (Long).
public interface LikeRepository extends JpaRepository<Like, Long> {
}
