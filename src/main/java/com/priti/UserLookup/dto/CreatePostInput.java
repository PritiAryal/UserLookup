package com.priti.UserLookup.dto;


import lombok.Data;
import jakarta.validation.constraints.NotBlank;

@Data
public class CreatePostInput {
    @NotBlank
    private String title;
    private String content;
    private Long authorId;
}
