package com.jrm2100.pessoa;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@CrossOrigin("*")
@RequestMapping("/cadastrar")
public class PessoaController {

    private final PessoaService repository;

    public PessoaController(PessoaService repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<Page<PessoaDTO>>buscarPessoas(@PageableDefault(size = 10)Pageable paginacao){
        Page<PessoaDTO> pessoaDTOS = repository.buscarPessoas(paginacao);

        return ResponseEntity.ok(pessoaDTOS);
    }


    @PostMapping
    public ResponseEntity<PessoaDTO> cadastrarPessoa(@RequestBody @Valid PessoaDTO dto, UriComponentsBuilder uriBuilder) {
        PessoaDTO pessoaDTO = repository.cadastrarPessoa(dto);

        URI endereco = uriBuilder.path("/cadastrar/{id}").buildAndExpand(pessoaDTO.getId()).toUri();

        return ResponseEntity.created(endereco).body(pessoaDTO);
    }

}
