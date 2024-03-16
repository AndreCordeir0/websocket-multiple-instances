package com.websocket.models;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity(name = "TB_USER")
public class User extends PanacheEntity {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id;

    @Column(updatable = false)
    private String nickname;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
}
