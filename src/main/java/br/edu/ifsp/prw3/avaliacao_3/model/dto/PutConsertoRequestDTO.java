package br.edu.ifsp.prw3.avaliacao_3.model.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record PutConsertoRequestDTO(
        @NotNull
        Long id,

        @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/(19|20)\\d{2}$", message = "Formato da data 'dataSaida' inválido.")
        String dataSaida,
        MecanicoDTO mecanico) {}