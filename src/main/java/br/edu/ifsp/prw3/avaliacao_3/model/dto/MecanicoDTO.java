package br.edu.ifsp.prw3.avaliacao_3.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

public record MecanicoDTO(
        @NotBlank
        @NotNull
        String nome,

        @PositiveOrZero
        int anosExperiencia) {}
