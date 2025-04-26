package br.edu.ifsp.prw3.avaliacao_3.controller;

import br.edu.ifsp.prw3.avaliacao_3.model.dto.ConsertoDTO;
import br.edu.ifsp.prw3.avaliacao_3.model.entities.Conserto;
import br.edu.ifsp.prw3.avaliacao_3.repository.ConsertoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
