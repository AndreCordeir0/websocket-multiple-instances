package com.websocket.dtos;

import java.time.LocalDateTime;

public class UserDTO {
    private Long id;
    private String nickname;
    private LocalDateTime createdAt;

    public Long getId() {
        return id;
    }

    public UserDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNickname() {
        return nickname;
    }

    public UserDTO setNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public UserDTO setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }
}