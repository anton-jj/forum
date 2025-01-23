package com.grupp4.forum.dto;

import com.grupp4.forum.comment.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.UUID;

@Data
@AllArgsConstructor
public class CommentResponseDTO {
    private String content;
    private String username;
    private UUID userId;
    private UUID postId;

    public static CommentResponseDTO fromModel(Comment comment) {
        return new CommentResponseDTO(
                comment.getContent(),
                comment.getUser().getName(),
                comment.getUser().getId(),
                comment.getPost().getId()
        );
    }
}
