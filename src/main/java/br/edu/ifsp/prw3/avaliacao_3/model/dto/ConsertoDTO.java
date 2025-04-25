package br.edu.ifsp.prw3.avaliacao_3.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ConsertoDTO(
        @NotBlank
        String dataEntrada,

        @NotBlank
        String dataSaida,

        @NotNull
        MecanicoDTO mecanico,

        @NotNull
        VeiculoDTO veiculo) {}
