package com.websocket.services;

import com.websocket.dtos.UserDTO;
import com.websocket.models.User;
import jakarta.enterprise.context.RequestScoped;

import java.time.LocalDateTime;

@RequestScoped
public class UserService {


    public UserDTO createUser(String nickname) {
        User user = new User()
                .setNickname(nickname)
                .setCreatedAt(LocalDateTime.now());
        user.persist();
        return new UserDTO()
                .setId(user.getId())
                .setNickname(user.getNickname())
                .setCreatedAt(user.getCreatedAt());
    }
}
