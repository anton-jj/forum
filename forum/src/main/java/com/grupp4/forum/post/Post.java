package com.grupp4.forum.post;

import com.grupp4.forum.comment.Comment;
import com.grupp4.forum.user.User;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Post {

    @Id
    private UUID id;
    private String content;


    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments;

    public Post(String content, User user){

        this.id = UUID.randomUUID();
        this.content = content;
        this.user = user;
        this.comments = new ArrayList<>();
    }
}
