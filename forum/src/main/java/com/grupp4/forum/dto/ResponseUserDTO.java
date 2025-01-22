package com.grupp4.forum.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
@Getter
public class ResponseUserDTO {
    private final String name;
    private final UUID id;
}
