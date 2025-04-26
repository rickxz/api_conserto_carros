package br.edu.ifsp.prw3.avaliacao_3.model.entities;

import br.edu.ifsp.prw3.avaliacao_3.model.dto.ConsertoDTO;
import br.edu.ifsp.prw3.avaliacao_3.model.dto.PutConsertoRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "consertos")
@Entity(name = "Conserto")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Conserto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dataEntrada;
    private String dataSaida;
    @Embedded
    private Mecanico mecanico;
    @Embedded
    private Veiculo veiculo;
    private boolean ativo = true;

    public Conserto(ConsertoDTO dto) {
        this.dataEntrada = dto.dataEntrada();
        this.dataSaida = dto.dataSaida();
        this.mecanico = new Mecanico(dto.mecanico());
        this.veiculo = new Veiculo(dto.veiculo());
    }

    public void atualizarInformacoes(PutConsertoRequestDTO dto) {
        if (dto.dataSaida() != null) this.dataSaida = dto.dataSaida();
        if (dto.mecanico() != null) this.mecanico.atualizarInformacoes(dto.mecanico());
    }
}
