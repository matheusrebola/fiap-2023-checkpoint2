package br.com.fiap.checkpoint2.cliente;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroCliente(
        @NotBlank
        String nome,
        @NotBlank
        String inscricao_federal,
        @NotBlank
        String cep
        )
{

}
