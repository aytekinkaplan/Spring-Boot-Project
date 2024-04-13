package com.project.springbootproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "p_like")
@Data
public class Like {
    @Id
    Long id;

    // Many-to-One relationship with Post entity
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false) // Foreign key column name in the like table
    @OnDelete(action = OnDeleteAction.CASCADE) // Cascade delete operation
    @JsonIgnore // Prevents Jackson from serializing this field to JSON
            Post post;

    // Many-to-One relationship with User entity
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false) // Foreign key column name in the like table
    @OnDelete(action = OnDeleteAction.CASCADE) // Cascade delete operation
    @JsonIgnore // Prevents Jackson from serializing this field to JSON
            User user;
}

// Explanation:
// @Entity: Specifies that the class is an entity. This annotation is applied to the class level.
// @Table(name = "p_like"): Specifies the table name for this entity in the database.
// @Data: Lombok annotation that automatically generates getter, setter, equals, hashCode, and toString methods.
// @Id: Specifies the primary key for the entity.
// @ManyToOne: Specifies a many-to-one relationship with another entity.
// @JoinColumn: Specifies the foreign key column name in the database.
// @OnDelete(action = OnDeleteAction.CASCADE): Specifies that a deletion of the parent entity will trigger a
// cascade delete of the associated child entities.
// @JsonIgnore: Indicates that the annotated field or property should be ignored during serialization and
// deserialization with Jackson.
