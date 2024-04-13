package com.project.springbootproject.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "p_like")
@Data
public class Like {
    @Id
    private Long id;
    private Long postId;
    private Long userId;
}
