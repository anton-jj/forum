package com.grupp4.forum.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@Data
@RequiredArgsConstructor
public class CreatePostDTO {
    public String content;
    public UUID userId;
}