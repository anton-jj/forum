package com.grupp4.forum.dto;

import com.grupp4.forum.post.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;


@AllArgsConstructor
@Getter
public class PostResponseDTO {
    private UUID id;
    private String content;
    private UUID userId;
    private String username;
//  private List<CommentController.CommentResponseDTO> comments;

    public static PostResponseDTO fromModel(Post post) {
        return new PostResponseDTO(
                post.getId(),
                post.getContent(),
                post.getUser().getId(),
                post.getUser().getName()
//              post.getComments().stream().map(CommentController.CommentResponseDTO::fromModel).toList()
        );
    }
}


