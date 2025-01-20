package com.grupp4.forum.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@Data
@RequiredArgsConstructor
public class CreateUserDTO {
    private String name;
    private String password;
}
