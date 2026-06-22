package br.com.galleriabank.desafio.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

public record CreateUserRequest (
    @NotBlank
    @Size(min = 3)
    String name,

    @NotBlank
    String login,

    @NotBlank
    String password
) {}
