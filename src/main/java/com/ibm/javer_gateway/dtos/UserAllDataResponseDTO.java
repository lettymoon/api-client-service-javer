package com.ibm.javer_gateway.dtos;

public record UserAllDataResponseDTO(String id, String cpf, String nome, String telefone, Boolean correntista, Double score_credito, Double saldo_cc) {
}