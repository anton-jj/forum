package com.grupp4.forum.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@Data
public class CreateUserDTO {
    private String password;
    private String name;
}
