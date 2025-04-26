package br.edu.ifsp.prw3.avaliacao_3.model.dto;

import jakarta.validation.constraints.*;

public record VeiculoDTO(
    @NotBlank
    String marca,

    @NotBlank
    String modelo,

    @Min(value = 1900, message = "O ano deve ser igual ou posterior a 1900")
    @Max(value = 2025, message = "O ano deve ser igual ou anterior a 2025")
    @NotNull
    int ano,

    String cor) {}
