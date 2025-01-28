package com.grupp4.forum.user;


import com.grupp4.forum.comment.Comment;
import com.grupp4.forum.post.Post;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity(name = "forum_user")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

    @Id
    private UUID id;

    private String name;
    private String password;


    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    @OneToMany(mappedBy = "user")
    private List<Comment> comments;

    public User(String name, String password) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.password = password;
    }
}
