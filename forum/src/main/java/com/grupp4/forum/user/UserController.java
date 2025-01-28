package com.grupp4.forum.user;

import com.grupp4.forum.dto.CreateUserDTO;
import com.grupp4.forum.dto.ResponseUserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /*
    create a new user
     */
    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody CreateUserDTO userDTO) {
        try {
            User user = userService.addUser(userDTO.getName(), userDTO.getPassword());
            return ResponseEntity.ok(new ResponseUserDTO(user.getName(), user.getId()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUser (@PathVariable UUID id, @RequestBody CreateUserDTO userDTO) {
       try {
           User updatedUser = userService.updateUser(id, userDTO.getName(), userDTO.getPassword());
           return ResponseEntity.ok().body(new ResponseUserDTO(updatedUser.getName(), updatedUser.getId()));
       } catch (Exception e ) {
           return ResponseEntity.badRequest().body(e.getMessage());
       }
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getUserById(@PathVariable UUID id) {
        try {
            User user = userService.getUserById(id);
            return ResponseEntity.ok(new ResponseUserDTO(user.getName(), user.getId()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable UUID id) {
        try {
            userService.deleteUser(id);
            return ResponseEntity.ok("User deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

