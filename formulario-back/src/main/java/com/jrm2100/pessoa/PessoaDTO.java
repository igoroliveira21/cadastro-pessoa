package com.jrm2100.pessoa;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    public PessoaDTO() {}

    @JsonIgnore
    public PessoaDTO(String message) {
    }

    public PessoaDTO(Pessoa pessoa) {
        this.id = pessoa.getId();
        this.nome = pessoa.getNome();
        this.telefone = pessoa.getTelefone();
        this.cpf = pessoa.getCpf();
        this.email = pessoa.getEmail();
        this.sexo = pessoa.getSexo();
        this.cep = pessoa.getCep();
        this.endereco = pessoa.getEndereco();
        this.numero = pessoa.getNumero();
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
