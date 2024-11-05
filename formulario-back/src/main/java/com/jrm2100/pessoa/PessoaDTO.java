package com.jrm2100.pessoa;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PessoaDTO {

    private Long id;
    private String nome;
    private String telefone;
    private String cpf;
    private String email;
    private String sexo;
    private String cep;
    private String endereco;
    private int numero;


    public Long getId() {
        return id;
    }
}
