package com.grupp4.forum.user;


import jakarta.persistence.Id;

import java.util.UUID;

public class User {

    @Id
    private UUID id;

    private String name;
    private String password;

    // Add in a forum topic list created by the user?

    // Add in a user comment list?

    // Liked topics & comments list?

    public User(String name, String password) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.password = password;
        // Forum topics created by user?
        // Forum comments created by user?
        // Forum topics and comments liked by the user?
    }
}
