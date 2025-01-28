package com.grupp4.forum.user;

import com.grupp4.forum.dto.ResponseUserDTO;
import com.grupp4.forum.util.PasswordUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordUtil passwordUtil;

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

        String hashedPassword = passwordUtil.hashPassword(password);

        User user = new User(username, hashedPassword);
        return userRepository.save(user);
    }


    public List<ResponseUserDTO> getAllUsers(){
       List<User> users =  userRepository.findAll();
       return users.stream().map(user -> new ResponseUserDTO(user.getName(), user.getId()))
               .collect(Collectors.toList());
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
