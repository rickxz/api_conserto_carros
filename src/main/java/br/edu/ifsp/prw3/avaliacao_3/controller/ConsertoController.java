package br.edu.ifsp.prw3.avaliacao_3.controller;

import br.edu.ifsp.prw3.avaliacao_3.model.dto.ConsertoDTO;
import br.edu.ifsp.prw3.avaliacao_3.model.dto.ConsertoRelatorio;
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

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/conserto")
public class ConsertoController {

    @Autowired
    private ConsertoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<Conserto> post(@RequestBody @Valid ConsertoDTO dto) {
        Conserto consertoSalvo = repository.save(new Conserto(dto));
        return new ResponseEntity<>(consertoSalvo, HttpStatus.CREATED);
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

}
