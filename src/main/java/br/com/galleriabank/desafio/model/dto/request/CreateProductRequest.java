package br.com.galleriabank.desafio.model.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record CreateProductRequest(
        @NotBlank
        String description,

        @DecimalMin("0.01")
        BigDecimal value
) {}
