package br.edu.ifsp.prw3.avaliacao_3.model.entities;

import br.edu.ifsp.prw3.avaliacao_3.model.dto.MecanicoDTO;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Mecanico {
    private String nome;
    private int anosExperiencia;

    public Mecanico(MecanicoDTO dto) {
        this.nome = dto.nome();
        this.anosExperiencia = dto.anosExperiencia();
    }

    public void atualizarInformacoes(MecanicoDTO dto) {
        if (dto.nome() != null) this.nome = dto.nome();
        this.anosExperiencia = dto.anosExperiencia();
    }
}
