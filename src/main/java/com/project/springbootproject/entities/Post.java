package com.project.springbootproject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "post")
@Data
public class Post {
    @Id
    Long id;

    // Many-to-One relationship with User entity
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false) // Foreign key column name in the post table
    @OnDelete(action = OnDeleteAction.CASCADE) // Cascade delete operation
    @JsonIgnore // Prevents Jackson from serializing this field to JSON
            User user;

    String title;

    // Large Object annotation for storing large text data
    @Lob
    @Column(columnDefinition = "text")
    String text;
}

// Explanation:
// @Entity: Specifies that the class is an entity. This annotation is applied to the class level.
// @Table(name = "post"): Specifies the table name for this entity in the database.
// @Data: Lombok annotation that automatically generates getter, setter, equals, hashCode, and toString methods.
// @Id: Specifies the primary key for the entity.
// @ManyToOne: Specifies a many-to-one relationship with another entity.
// @JoinColumn: Specifies the foreign key column name in the database.
// @OnDelete(action = OnDeleteAction.CASCADE): Specifies that a deletion of the parent entity will trigger a cascade
// delete of the associated child entities.
// @JsonIgnore: Indicates that the annotated field or property should be ignored during serialization and
// deserialization with Jackson.
// @Lob: Indicates that the annotated field or property should be stored as a Large Object in the database.
// @Column(columnDefinition = "text"): Specifies the column definition for the annotated field or property.
// In this case, it defines the column as a text type in the database.
