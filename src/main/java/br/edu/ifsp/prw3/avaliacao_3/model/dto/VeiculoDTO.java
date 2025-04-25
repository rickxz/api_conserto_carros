package br.edu.ifsp.prw3.avaliacao_3.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record VeiculoDTO(
    @NotBlank
    String marca,

    @NotBlank
    String modelo,

    @Positive
    int ano) {}
