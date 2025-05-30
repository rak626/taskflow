package com.rakesh.taskflow.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "labels")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Label {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String color;
    /**
     * If `user` is null, the label is GLOBAL (available to all users).
     * If `user` is non-null, it's a user-specific label.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = true)
    private User user;

    @ToString.Exclude
    @ManyToMany(mappedBy = "label")
    private Set<Todo> todos = new HashSet<>();
}
