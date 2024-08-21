package com.ibm.javer_gateway.dtos;

public record UserRequestDTO(String cpf, String nome, String telefone, Boolean correntista, Double saldo_cc) {
}