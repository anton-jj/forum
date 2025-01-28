package com.grupp4.forum.comment;

import com.grupp4.forum.post.Post;
import com.grupp4.forum.user.User;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Comment {

    @Id
    private UUID id;
    private String content;

    @ManyToOne
    private User user;

    @ManyToOne
    private Post post;

    public Comment(String content, User user, Post post) {
        this.id = UUID.randomUUID();
        this.content = content;
        this.user = user;
        this.post = post;
    }
}
