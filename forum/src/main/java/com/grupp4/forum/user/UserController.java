package com.grupp4.forum.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /*
    create a new user
     */
    @PostMapping
    public ResponseEntity<?> createUser(@RequestParam UserCreateDTO userDTO) {

    }

    /*
      returning a user  by uuid
     */
   @GetMapping("/{id}")
   public ResponseEntity<?> getUser(@PathVariable UUID id) {
       /*
        getting a user by id from the service
        */
       return null;
   }

   @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable UUID id) {
        /*
        Deleting a user calling service and repository
         */
   }
}
