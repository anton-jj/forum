/**
 *
 *
 */


package com.grupp4.forum.post;

import com.grupp4.forum.user.User;
import com.grupp4.forum.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;


  //Create posts
    public Post createPost(String content, UUID userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("Can not find user"));
        Post post = new Post(content, user);
        return postRepository.save(post);
    }

    //View all posts in forum with pagination
    public Collection<Post> getAllPosts(int page) {
        return postRepository.findAll(PageRequest.of(page, 10)).toList();
    }
}
