package com.project.springbootproject.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "comment")
@Data
public class Comment {
    @Id
    private Long id;
    private Long postId;
    private Long userId;
    @Lob
    @Column(columnDefinition = "text")
    String text;
}
