package br.edu.ifsp.prw3.avaliacao_3.controller;

import br.edu.ifsp.prw3.avaliacao_3.model.dto.ConsertoDTO;
import br.edu.ifsp.prw3.avaliacao_3.model.dto.ConsertoRelatorio;
import br.edu.ifsp.prw3.avaliacao_3.model.dto.PutConsertoRequestDTO;
import br.edu.ifsp.prw3.avaliacao_3.model.dto.PutConsertoResponseDTO;
import br.edu.ifsp.prw3.avaliacao_3.model.entities.Conserto;
import br.edu.ifsp.prw3.avaliacao_3.repository.ConsertoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/consertos")
public class ConsertoController {

    @Autowired
    private ConsertoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity post(@RequestBody @Valid ConsertoDTO dto,
                                         UriComponentsBuilder uriBuilder) {
        Conserto consertoSalvo = repository.save(new Conserto(dto));

        var uri = uriBuilder.path("/consertos/{id}").buildAndExpand(consertoSalvo.getId()).toUri();
        return ResponseEntity.created(uri).body(consertoSalvo);
    }

    @GetMapping
    public ResponseEntity<Page<Conserto>> list(Pageable pageable) {
        Page<Conserto> consertos = repository.findAll(pageable);
        return ResponseEntity.ok(consertos);
    }

    @GetMapping("relatorio")
    public ResponseEntity<List<ConsertoRelatorio>> relatorio() {
        List<ConsertoRelatorio> consertos = repository.findAllByAtivoTrue().stream().map(ConsertoRelatorio::new).toList();
        return ResponseEntity.ok(consertos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conserto> getById(@PathVariable Long id) {
        Optional<Conserto> conserto = repository.findById(id);
        return conserto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Object> atualizar(@RequestBody @Valid PutConsertoRequestDTO dto) {
        Optional<Conserto> conserto = repository.findById(dto.id());

        if (conserto.isPresent()) {
            conserto.get().atualizarInformacoes(dto);
            return ResponseEntity.ok(new PutConsertoResponseDTO(conserto.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Object> excluir(@PathVariable Long id) {
        Optional<Conserto> conserto = repository.findById(id);
        if (conserto.isPresent()) {
            conserto.get().excluir();
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}
