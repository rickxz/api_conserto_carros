package br.edu.ifsp.prw3.avaliacao_3.model.dto;

import br.edu.ifsp.prw3.avaliacao_3.model.entities.Conserto;

public record ConsertoRelatorio(String dataEntrada, String dataSaida, String nome, String marca, String modelo) {
    public ConsertoRelatorio(Conserto conserto) {
        this(
                conserto.getDataEntrada(),
                conserto.getDataSaida(),
                conserto.getMecanico().getNome(),
                conserto.getVeiculo().getMarca(),
                conserto.getVeiculo().getModelo()
        );
    }
}
