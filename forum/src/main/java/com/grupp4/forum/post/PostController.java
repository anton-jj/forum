package com.grupp4.forum.post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postservice;

    @PostMapping
    public ResponseEntity<?> createPost(@RequestBody CreatePostDTO createPostDto) {

        try {
            Post post = postservice.createPost(createPostDto.content, createPostDto.userId);
            return ResponseEntity.ok(PostResponseDTO.fromModel(post));
        }catch (Exception exception) {
            return ResponseEntity.badRequest().body("Hoppsan här blev det fel (ska va errorResponseDTO");
        }
    }

    public static class CreatePostDTO {

        public String content;
        public UUID userId;
    }

    @AllArgsConstructor
    @Getter
    public static class PostResponseDTO {
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
//                    post.getComments().stream().map(CommentController.CommentResponseDTO::fromModel).toList()
            );
        }
    }


}
