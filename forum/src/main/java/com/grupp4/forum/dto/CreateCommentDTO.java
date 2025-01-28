package com.grupp4.forum.dto;

import com.grupp4.forum.comment.Comment;
import com.grupp4.forum.post.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
@Getter
public class CreateCommentDTO {
    public String content;
    public UUID postId;
    public UUID userId;
}
