package com.priti.UserLookup.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateUserInput {
    @NotBlank
    private String name;

    @Email
    private String email;
}
