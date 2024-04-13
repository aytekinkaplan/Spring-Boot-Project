package com.project.springbootproject.repository;

import com.project.springbootproject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

// This interface extends JpaRepository, which provides the basic CRUD operations for the User entity.
// JpaRepository<User, Long>: Specifies the entity type (User) and the type of its primary key (Long).
public interface UserRepository extends JpaRepository<User, Long> {

}
