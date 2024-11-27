package com.jrm2100.pessoa;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static com.jrm2100.validator.ValidarPessoa.validarPessoa;

@Service
public class PessoaService {
    private final PessoaRepository repository;

    private final ModelMapper modelMapper;

    public PessoaService(PessoaRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    public PessoaDTO cadastrarPessoa(PessoaDTO dto){
        validarPessoa(dto);
        Pessoa pessoa = modelMapper.map(dto, Pessoa.class);
        repository.save(pessoa);
        return modelMapper.map(pessoa, PessoaDTO.class);
    }
//    public PessoaDTO cadastrarPessoa(PessoaDTO dto) {
//        Pessoa pessoa = modelMapper.map(dto, Pessoa.class);
//        repository.save(pessoa);
//        return modelMapper.map(pessoa, PessoaDTO.class);
//    }

        public Page<PessoaDTO> buscarPessoas (Pageable paginacao){
            return repository.findAll(paginacao)
                    .map(p -> modelMapper.map(p, PessoaDTO.class));
        }

    }
