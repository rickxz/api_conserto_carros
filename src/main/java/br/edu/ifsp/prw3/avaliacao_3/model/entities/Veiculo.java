package br.edu.ifsp.prw3.avaliacao_3.model.entities;
import br.edu.ifsp.prw3.avaliacao_3.model.dto.VeiculoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Veiculo {
    private String marca;
    private String modelo;
    private int ano;

    public Veiculo(VeiculoDTO dto) {
        this.marca = dto.marca();
        this.modelo = dto.modelo();
        this.ano = dto.ano();
    }
}
