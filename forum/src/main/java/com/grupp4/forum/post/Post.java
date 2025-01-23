package com.grupp4.forum.post;


import com.grupp4.forum.user.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    //@OneToMany
    //private List<Comment> comments;

    public Post(String content, User user){

        this.id = UUID.randomUUID();
        this.content = content;
        this.user = user;
    }
}
