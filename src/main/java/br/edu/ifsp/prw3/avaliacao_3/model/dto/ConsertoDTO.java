package br.edu.ifsp.prw3.avaliacao_3.model.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record ConsertoDTO(
        @NotBlank
        @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/(19|20)\\d{2}$", message = "Formato da data 'dataEntrada' inválido.")
        String dataEntrada,

        @NotBlank
        @Pattern(regexp = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/(19|20)\\d{2}$", message = "Formato da data 'dataSaida' inválido.")
        String dataSaida,

        @NotNull
        @Valid
        MecanicoDTO mecanico,

        @NotNull
        @Valid
        VeiculoDTO veiculo) {}
