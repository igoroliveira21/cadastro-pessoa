package com.jrm2100.validator;

import com.jrm2100.pessoa.PessoaDTO;

public class ValidarPessoa {

    public static void validarPessoa(PessoaDTO dto) {
        if (dto.getNome() == null || dto.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("O nome é obrigatório");
        }

        if (dto.getTelefone() == null || dto.getTelefone().trim().isEmpty()) {
            throw new IllegalArgumentException("O telefone é obrigatório");
        }

        if (dto.getCpf() == null || !isValidCPF(dto.getCpf())) {
            throw new IllegalArgumentException("CPF inválido");
        }

        ValidarEmail.validarEmail(dto.getEmail());

        if (dto.getCep() == null && dto.getCep().matches("\\d{5}-\\d{3}")) {
            throw new IllegalArgumentException("O CEP deve seguir o formato 12345-678");
        }

        if (dto.getNumero() <= 0) {
            throw new IllegalArgumentException("O número deve ser maior que 0");
        }

    }

    private static boolean isValidCPF(String cpf) {
        return cpf != null && cpf.matches("\\d{11}");
    }
}
