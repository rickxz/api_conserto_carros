package br.edu.ifsp.prw3.avaliacao_3.repository;

import br.edu.ifsp.prw3.avaliacao_3.model.entities.Conserto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsertoRepository extends JpaRepository<Conserto, Long> {
    List<Conserto> findAllByAtivoTrue();
}
