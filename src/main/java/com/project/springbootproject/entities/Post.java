package com.project.springbootproject.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "post")
@Data
public class Post {
    @Id
    private Long id;
    private Long userId;
    private String title;
    @Lob
    @Column(columnDefinition = "text")
    private String text;
}
