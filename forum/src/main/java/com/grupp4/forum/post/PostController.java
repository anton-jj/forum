package com.grupp4.forum.post;

import com.grupp4.forum.dto.CreatePostDTO;
import com.grupp4.forum.dto.PostResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;


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



    @GetMapping
    public Stream<PostResponseDTO> getPosts(@RequestParam int page){
        return postservice.getAllPosts(page).stream().map(PostResponseDTO::fromModel);
    }
}
