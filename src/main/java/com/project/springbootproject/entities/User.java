package com.project.springbootproject.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "user")
@Data
public class User {
    @Id
    Long id;

    String userName;

    String password;
}

// Explanation:
// @Entity: Specifies that the class is an entity. This annotation is applied to the class level.
// @Table(name = "user"): Specifies the table name for this entity in the database.
// @Data: Lombok annotation that automatically generates getter, setter, equals, hashCode, and toString methods.
// @Id: Specifies the primary key for the entity.
