package com.grupp4.forum.comment;

import com.grupp4.forum.dto.CommentResponseDTO;
import com.grupp4.forum.dto.CreateCommentDTO;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public ResponseEntity<?> commentOnPost(@RequestBody CreateCommentDTO createCommentDto) {
        try {
            Comment comment = commentService.respondToPost(createCommentDto.content, createCommentDto.postId, createCommentDto.userId);
            return ResponseEntity.ok(CommentResponseDTO.fromModel(comment));
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body("Error: Should be ErrorResponseDTO.");
        }
    }
}
