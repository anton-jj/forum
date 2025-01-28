package com.grupp4.forum.comment;

import com.grupp4.forum.post.Post;
import com.grupp4.forum.post.PostRepository;
import com.grupp4.forum.user.User;
import com.grupp4.forum.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public Comment respondToPost(String content, UUID postId, UUID userId) {
        User user = userRepository
                .findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found."));

        Post post = postRepository
                .findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("Topic not found."));

        Comment comment = new Comment(content, user, post);
        return commentRepository.save(comment);
    }
}
