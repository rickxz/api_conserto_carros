package br.edu.ifsp.prw3.avaliacao_3.model.dto;

import br.edu.ifsp.prw3.avaliacao_3.model.entities.Conserto;
import br.edu.ifsp.prw3.avaliacao_3.model.entities.Mecanico;
import br.edu.ifsp.prw3.avaliacao_3.model.entities.Veiculo;

public record PutConsertoResponseDTO(
        Long id,
        String dataEntrada,
        String dataSaida,
        Mecanico mecanico,
        Veiculo veiculo,
        boolean ativo
) {
    public PutConsertoResponseDTO (Conserto conserto) {
        this(
                conserto.getId(),
                conserto.getDataEntrada(),
                conserto.getDataSaida(),
                conserto.getMecanico(),
                conserto.getVeiculo(),
                conserto.isAtivo()
        );
    }
}