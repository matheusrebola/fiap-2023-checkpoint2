package br.com.fiap.checkpoint2.cliente;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoCliente(@NotNull Long codigo_cliente, String data_pedido){

}
