package com.grupp4.forum.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User addUser(String username, String password) {
        if (username == null || username.isBlank()) {
            throw new IllegalArgumentException("Username cannot be empty and/or null.");
        }

        if (username.length() < 2 ) {
            throw new IllegalArgumentException("Username cannot be less than 2 characters.");
        }

        if (password == null || password.isBlank()) {
            throw new IllegalArgumentException("Password cannot be empty and/or null.");
        }

        if (password.length() < 7) {
            throw new IllegalArgumentException("Password cannot be less than 7 characters.");
        }


        User user = new User(username, password);
        return userRepository.save(user);
    }

    public User updateUser(UUID id, String username, String password) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found"));

        if (username != null && !username.isBlank()) {
            user.setName(username);
        }

        if (password != null && !password.isBlank())  {
            if (password.length() < 7 ) {
                throw new IllegalArgumentException("Password cannot be less than 7 characters.");
            }
            user.setPassword(password);
        }
        return userRepository.save(user);
    }

    public User getUserById(UUID id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found"));
    }

    public void deleteUser(UUID id) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found"));
        userRepository.delete(user);
    }
}
